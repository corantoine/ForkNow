package fr.simplon.spring_security.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.simplon.spring_security.dto.ShopDto;
import fr.simplon.spring_security.model.Shop;
import fr.simplon.spring_security.service.ShopService;
import jakarta.validation.Valid;

@Controller
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    //Route pour accéder au formulaire de création d'un restaurant
    @GetMapping("/creation-resto")
    public String addResto(Model model){
        ShopDto shop = new ShopDto();
        model.addAttribute("shop", shop);
        return "add-resto";
    }

    // Route pour afficher les différents restaurants
    @GetMapping("/restaurant")
    public String resto(Model model){
        List<Shop> allShops = shopService.getAllShops();
        model.addAttribute("shops", allShops);
        return "forknow-restaurants-list";
    }

    // Route pour enregistrer un nouveau restaurant dans la base de données
    @PostMapping("/creation-resto/save")
    public String addResto(@Valid @ModelAttribute("shop") ShopDto shopMapping){
        shopService.saveShop(shopMapping);
        return "redirect:/restaurant";
    }
}
