package fr.simplon.spring_security.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Objet de transfert de données pour la création d'un restaurant
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShopDto {
    private String name;
    private String address;

}
