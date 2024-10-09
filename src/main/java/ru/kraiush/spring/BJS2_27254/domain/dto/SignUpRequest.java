package ru.kraiush.spring.BJS2_27254.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Registration request")
public class SignUpRequest {

    @Schema(description = "Username", example = "Jon")
    @Size(min = 5, max = 20, message = "The user name must contain from 5 to 20 characters")
    @NotBlank(message = "The username cannot be empty")
    private String username;

    @Schema(description = "Email address", example = "jondoe@gmail.com")
    @Size(min = 5, max = 255, message = "The email address must contain from 5 to 255 characters")
    @NotBlank(message = "The email address cannot be empty")
    @Email(message = "The email address must be in the format user@example.com")
    private String email;

    @Schema(description = "Password")
    @Size(max = 50, message = "The password must be no more than 50 characters long")
    private String password;
}