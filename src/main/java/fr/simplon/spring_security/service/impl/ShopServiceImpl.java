package fr.simplon.spring_security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.simplon.spring_security.dto.ShopDto;
import fr.simplon.spring_security.model.Shop;
import fr.simplon.spring_security.repository.ShopRepository;
import fr.simplon.spring_security.service.ShopService;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;

    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    //Méthode de création d'un restaurant en base de données
    @Override
    public void saveShop(ShopDto shopMapping) {
        Shop shopEntity = Shop.builder()
                .name(shopMapping.getName())
                .address(shopMapping.getAddress())
                .build();
        shopRepository.save(shopEntity);
    }

    //Méthode de récupération des restaurants
    @Override
    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }
}
