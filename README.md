# ForkNow

## Description
ForkNow est une application de livraisons de plat à domicile.

## Prérequis
- Git
- Java JDK 17+
- Gradle
- PostgreSQL

## Installation 
1. **Clôner le dépôt afin de récupérer le projet**
    ```bash
   git clone https://github.com/corantoine/ForkNow.git
   
2. **Configurer la base de données PostgreSQL**

- Se connecter à PostgreSQL
- Créer la base de données forknow :
- ``CREATE DATABASE forknow;``

3. **Construire le projet** : 
```bash
./gradle build
```

## Construire le projet

- Utiliser la commande ``./gradlew bootrun`` 
- Ouvrir un navigateur et aller sur http://localhost:8080

## Utilisation
- Créer un compte utilisateur
- Se connecter au site
- Accéder à la page profil
- Accéder à la page restaurants
- Accéder à la création d'un restaurant
