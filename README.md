# bdgest-jkl-spring

## BDGest from group

> LACERENZA Loris, KHIAL Omar, JUBARD Théo

### Créer la BDD en local
- Après avoir installer docker, lancer le container postgres avec :<br>
```
docker run --name postgresql-container -p 5432:5432 -e POSTGRES_PASSWORD=somePassword -d postgres
```
- Vous devez ensuite vous connecter a la BDD depuis IntelliJ avec les identifiants suivants, dans databases vous pourrez mettre en place une connexion avec la BDD :<br>
```
url: localhost
user: postgres
password: somePassword
```


SOURCE SCRAPPING : 
- Mavel Developer : https://developer.marvel.com/
- MyAnimeList : https://myanimelist.net/apiconfig/references/api/v2#tag/manga
- MySQL BDD

BDD : (pgadmin)[http://pgadmin.omarmelade.com/]
API : (API)[http://bdgest-jkl-api.omarmelade.com/]
WEB : (React)[http://bdgest-jkl.omarmelade.com/]


#SUJET :

# BDGest


## But :

* Realiser une application de gestion de collection de bande dessinée.


## Participants Groupe 1:
* : Jubard Théo
* : Khial Omar
* : Lacerenza Loris

## Fonctionnalitées :

* [x] application mutli-utilisateur (s'enregistrer / supprimer son compte)
* [x] je peux visualiser une album (ISBN, titre, image série, numéro d'ordre pour la série), une série (liste des albums appartenant a la série par ordre dans la série)
* [x] je peux rechercher des bandes dessinée par auteur / série / titre / isbn,
* [x] je peux marquer un album comm faisant partie de ma collection
* je peux marquer une série, un auteur comme suivie.
* ma home page indique : le nombre ainsi  que les 5 premiéres séries


### Focntionalitées Bonus (point bonus si fonctionnalité présente et correctement implémenté):
+ 3 : je peux partager ma collection en lecture seule a travers un qr code
+ 2 : je peux marquer un album comme prété (a date, a quelqu'un)


## si 3 éme membre

un total de 5K BD doit être chargé dans la base,
vous ecrirez un outil de scrapping du site web de votre choix. (forcéement différent pour les deux groupes)
cette fonctionalité doit être accessible via une page d'admin et presenter la date du dernier import et le nombre de nouvelles BD importées 
 
