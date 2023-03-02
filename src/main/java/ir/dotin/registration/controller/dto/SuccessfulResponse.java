package ir.dotin.registration.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SuccessfulResponse {

    @JsonProperty("code")
    private int code;

    @JsonProperty("message")
    private String message;
}
