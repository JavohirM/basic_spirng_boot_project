package uz.writer.dao.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class Report implements Serializable {

    @JsonProperty("client_doc")
    private String clientDoc;
    @JsonProperty("client_phone")
    private String clientPhone;
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("ban_id")
    private Integer banId;
    @JsonProperty("code")
    private String code;
}
