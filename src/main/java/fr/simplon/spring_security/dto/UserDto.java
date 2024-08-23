package fr.simplon.spring_security.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Objet de transfert de données pour loguer l'utilisateur

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @NotEmpty(message = "Username must not be empty")
    private String username;

    @NotEmpty(message = "Password must not be empty")
    private String password;
}

//TODO : boutons accueil
//TODO : profil afficher les infos utilisateurs
//TODO : modification données formulaire de création resto (photo?)
//TODO :