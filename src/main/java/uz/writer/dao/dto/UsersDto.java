package uz.writer.dao.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.writer.dao.model.Roles;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsersDto implements Serializable {

    private static final long serialVersionUID = 5190598237215532909L;

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("created_at")
    private String createdAt = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date());
    @NotEmpty(message = "Username should not be empty!")
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    @NotEmpty(message = "Password should not be empty!")
    private String password;
    @JsonProperty("branch_code")
    @NotEmpty(message = "Branch Code should not be empty!")
    private String branchCode;
    @JsonProperty("is_enabled")
    private Boolean isEnabled;
    @JsonProperty("roles")
    @NotEmpty(message = "Roles should not be empty!")
    private List<Roles> roles;
}
