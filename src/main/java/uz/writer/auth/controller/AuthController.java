package uz.writer.auth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uz.writer.auth.jwt.AuthRequest;
import uz.writer.auth.jwt.AuthResponse;
import uz.writer.auth.service.AuthHandler;
import uz.writer.dao.dto.ResultDto;
import uz.writer.dao.dto.UsersDto;

/**
 * Project:  csv_writer
 * Author: javohir.toshtemirovich@gmail.com
 * Date:  10.08.2022
 */
@RestController
public class AuthController {
    private final AuthHandler handler;

    public AuthController(AuthHandler handler) {
        this.handler = handler;
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public ResponseEntity<?> signup(@RequestBody UsersDto dto) {

        ResultDto signup = handler.signup(dto);
        if(signup.getCode().equals("200")){
            return new ResponseEntity<>(signup, HttpStatus.OK);
        }
        return new ResponseEntity<>(signup, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody AuthRequest dto) {

        AuthResponse login = handler.login(dto);
        if(login.getStatus() == 200){
            return new ResponseEntity<>(login, HttpStatus.OK);
        }
        return new ResponseEntity<>(login, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/api/test", method = RequestMethod.GET)
    public String test(){
        return "test";
    }

}
