package uz.writer.dao.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthPrincipal implements Serializable {
    private static final long serialVersionUID = 6336401718109857445L;

    @JsonProperty("principal")
    private String principal;
    @JsonProperty("authorities")
    private List<AuthoritiesDTO> authorities;
    @JsonProperty("authenticated")
    private Boolean authenticated;

    @NoArgsConstructor
    @Data
    public static class AuthoritiesDTO implements Serializable {
        private static final long serialVersionUID = 6336401718109857445L;

        @JsonProperty("role")
        private String role;
    }
}
