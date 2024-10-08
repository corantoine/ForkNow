package fr.simplon.spring_security.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// Objet de transfert de données pour l'inscription d'utilisateurs.

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
    @NotEmpty(message = "Username must not be empty")
    private String username;

    @NotEmpty(message = "Display name must not be empty")
    private String displayName;

    @NotEmpty(message = "Email must not be empty")
    private String email;

    @NotEmpty(message = "Password must not be empty")
    private String password;
    
    @NotEmpty(message = "PasswordConfirm must not be empty")
    private String passwordConfirm;
}
