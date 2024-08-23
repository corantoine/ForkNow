package fr.simplon.spring_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.simplon.spring_security.model.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long > {

}
