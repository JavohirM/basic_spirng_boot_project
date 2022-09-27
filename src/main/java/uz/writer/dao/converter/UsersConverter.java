package uz.writer.dao.converter;

import org.springframework.stereotype.Component;
import uz.writer.dao.dto.UsersDto;
import uz.writer.dao.model.Users;

@Component
public class UsersConverter extends GenericConverter<UsersDto, Users> {

    public UsersConverter() {
        super(dto -> new Users(dto.getId(), dto.getCreatedAt(), dto.getUsername(), dto.getPassword(), dto.getBranchCode(), dto.getIsEnabled(), dto.getRoles()),
                entity -> new UsersDto(entity.getId(), entity.getCreatedAt(), entity.getUsername(), entity.getPassword(), entity.getBranchCode(), entity.getIsEnabled(), entity.getRoles()));
    }
}
