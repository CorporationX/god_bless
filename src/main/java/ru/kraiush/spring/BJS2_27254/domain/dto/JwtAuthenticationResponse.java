package ru.kraiush.spring.BJS2_27254.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Response with access token")
public class JwtAuthenticationResponse {

    @Schema(description = "Access Token")
    private String token;
}
