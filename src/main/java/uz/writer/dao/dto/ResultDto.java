package uz.writer.dao.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultDto implements Serializable {
    @JsonProperty("code")
    private String code;
    @JsonProperty("message")
    private String message;
}
