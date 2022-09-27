package uz.writer.dao.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("users")
public class Users implements Serializable {

    private static final long serialVersionUID = 5190598237215532909L;

    @Id
    private Integer id;
    @Column("created_at")
    @SerializedName(value = "createdAt", alternate = {"created_at"})
    private String createdAt = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date());
    @Column("username")
    @NotEmpty(message = "Username should not be empty!")
    private String username;
    @Column("password")
    @NotEmpty(message = "Password should not be empty!")
    private String password;
    @Column("branch_code")
    @JsonProperty("branch_code")
    @SerializedName(value = "branch_code", alternate = {"branchCode"})
    @NotEmpty(message = "Branch Code should not be empty!")
    private String branchCode;
    @Column("is_enabled")
    @JsonProperty("is_enabled")
    @SerializedName(value = "is_enabled", alternate = {"isEnabled"})
    private Boolean isEnabled;
    @Column("roles")
    @NotEmpty(message = "Roles should not be empty!")
    private List<Roles> roles;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equal(username, users.username)
                && Objects.equal(password, users.password)
                && Objects.equal(branchCode, users.branchCode)
                && Objects.equal(isEnabled, users.isEnabled)
                && Objects.equal(roles, users.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username, password, branchCode, isEnabled, roles);
    }
}
