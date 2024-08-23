package fr.simplon.spring_security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;
import fr.simplon.spring_security.dto.RegisterDto;
import fr.simplon.spring_security.dto.ShopDto;
import fr.simplon.spring_security.model.User;
import fr.simplon.spring_security.service.UserService;
import jakarta.validation.Valid;

//Fichier de configuration des différentes routes concernant l'authentification de l'utilisateur.

@Controller
public class AuthController {

    private final UserService userService;

    //Injection de dépendance du service utilisateur
    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // Route pour la page d'accueil
    @GetMapping("/")
    public String home(Model model, Authentication authentication) {
        Optional<User> user = userService.from(authentication);
        if(user.isPresent()){
            //Ajoute l'utilisateur courant au modele
            model.addAttribute("currentUser", user.get());
        }
        return "forknow-index";
    }

    // Route pour la page admin
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    // Route pour la page profil
    @GetMapping("/profile")
    public String profile(){
        return "profile";
    }

    //Route pour la page d'inscription
    @GetMapping("/register")
    public String register(Model model) {
        RegisterDto user = new RegisterDto();
        model.addAttribute("user", user);
        return "register";

    }

// Route pour enregistrer un nouvel utilisateur
    @PostMapping("/register/save")
    public String registerUser(@Valid @ModelAttribute RegisterDto userMapping) {
        System.out.println("Ok");
        //Vérification de la correspondance des mots de passe
        if(!userMapping.getPassword().equals(userMapping.getPasswordConfirm())){
            return "redirect:/register?error";
        }
        userService.saveUser(userMapping);
        return "redirect:/login?success=userRegistred";
    }
}
