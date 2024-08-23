package fr.simplon.spring_security.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UserInShop {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User users;

        @ManyToOne
        @JoinColumn(name = "shop_id")
        private Shop shops;

        // Champs supplémentaires
        private LocalDateTime joinDate;
        private UserRole role;
    }

