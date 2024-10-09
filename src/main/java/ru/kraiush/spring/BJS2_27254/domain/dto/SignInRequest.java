package ru.kraiush.spring.BJS2_27254.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Authentication Request")
public class SignInRequest {

    @Schema(description = "Username", example = "John Lennon")
    @Size(min = 5, max = 20, message = "The user name must contain from 5 to 20 characters")
    @NotBlank(message = "The username cannot be empty")
    private String username;

    @Schema(description = "Password")
    @Size(min = 8, max = 50, message = "The password must be between 8 and 50 characters long")
    @NotBlank(message = "The password cannot be empty")
    private String password;
}