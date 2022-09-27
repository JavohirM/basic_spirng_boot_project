package uz.writer.auth.jwt;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.writer.dao.dto.UsersDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthResponse {

    private String a_t;
    private String description;
    private Integer status;
    private UsersDto users;

    public AuthResponse(Integer status, String description) {
        this.status = status;
        this.description = description;
    }

    public AuthResponse(String a_t, Integer status, String description, UsersDto users) {
        this.a_t = a_t;
        this.status = status;
        this.description = description;
        this.users = users;
    }
}
