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
