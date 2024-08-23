package fr.simplon.spring_security.service;

import java.util.List;

import fr.simplon.spring_security.dto.ShopDto;
import fr.simplon.spring_security.model.Shop;

public interface ShopService {
    public void saveShop(ShopDto shopMapping);

    List<Shop> getAllShops();
}
