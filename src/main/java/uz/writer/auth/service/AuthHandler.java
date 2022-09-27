package uz.writer.auth.service;

import com.google.common.base.Strings;
import org.springframework.stereotype.Component;
import uz.writer.auth.encode.PassEncoder;
import uz.writer.auth.jwt.AuthRequest;
import uz.writer.auth.jwt.AuthResponse;
import uz.writer.auth.jwt.JwtUtil;
import uz.writer.dao.converter.UsersConverter;
import uz.writer.dao.dto.ResultDto;
import uz.writer.dao.dto.UsersDto;
import uz.writer.dao.model.Users;
import uz.writer.service.UsersService;


@Component
public class AuthHandler {

    private final UsersService usersService;
    private final PassEncoder passEncoder;
    private final JwtUtil jwtUtil;
    private final UsersConverter usersConverter;

    public AuthHandler(UsersService usersService, PassEncoder passEncoder, JwtUtil jwtUtil, UsersConverter usersConverter) {
        this.usersService = usersService;
        this.passEncoder = passEncoder;
        this.jwtUtil = jwtUtil;
        this.usersConverter = usersConverter;
    }

    public AuthResponse login(AuthRequest request) {

        Users byUserName = usersService.getByUserName(request.getUsername());
        if (Strings.isNullOrEmpty(byUserName.getUsername())) {
            return new AuthResponse(400, "Invalid credentials");
        }
        if (passEncoder.matches(request.getPassword(), byUserName.getPassword())) {

            return new AuthResponse(jwtUtil.generateToken(byUserName), 200, "Authenticated!", usersConverter.convertFromEntity(byUserName));
        }

        return new AuthResponse(400, "User does not exists");
    }

    public ResultDto signup(UsersDto dto) {
        if (usersService.getByUserName(dto.getUsername()) == null) {
            return new ResultDto("400", "User already exists");
        }
        dto.setPassword(passEncoder.encode(dto.getPassword()));

        Users users = usersService.createUsers(usersConverter.convertFromDto(dto));

        return new ResultDto("200", "User is created");
    }

}
