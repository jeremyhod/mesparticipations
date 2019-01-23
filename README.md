# mesparticipations

Jérémy HODEBERT - Master 2 informatique (EID2)

**Mini-projet :**

Aspirateur de données de participations à des cours
(*mesparticipations* (selfdata :api)) 
https://github.com/jeremyhod/mesparticipations

**Enseignants :** Flavien BREUVART & Pierre BOUDES

## 1. Présentation du projet
Le projet *mesparticipations* consiste en un aspirateur de données de participations à des cours sous forme d'api.

Une participation se caractérise par : 
- un id
- un type d’événement
- un nom d'événement
- un type de participation
- des dates de début et de fin d'événement
- une durée
- une présence

## 2. Technologies
Pour faire cette api (conforme au style d'architecture REST) j'ai choisi d'utiliser **Spring Boot** avec **Intellij**. Spring Boot est un framework qui facilite le développement d'applications fondées sur Spring. Nous allons ainsi faire un microservice capable d'extraire les données concernant les participations. 

Metada de notre api REST :

- Type : **Maven Project**
- Langage : **Java**
- Dépendances : 
  * **Web** : 	"Building a RESTFUL Web Service, Serving Web Content with Spring MVC, Building REST services with Spring, Reference
	doc".  
  -> api REST.
  * **JPA** : 	"Java Persistence API including spring-data-jpa, spring-or and Hibernate".  
  -> On l'utilise pour communiquer avec la base de données.
  * **H2** : 	"H2 database (with embedded support)"".  
  -> J'ai choisi ce type de base (H2) car elle est suffisante dans le cadre de ces mini-projets (plus facile à tester). Elle intégrable directement dans notre microservice et elle est légère. Elle va créer les tables et les données uniquement en mémoire vive.
  * **OpenCSV**.  
  -> Il s'agit d'une bibliothèque gratuite qui simplifie la lecture complexe des fichiers CSV.

## 3. Utilisation de l'api 

- Installez Intellij (voir le TP0 des cours de LEE).
- Téléchargez le projet *mesparticipations* sur https://github.com/jeremyhod/mesparticipations. Vous obtenez ""mesparticipations-master".
- Ouvrez Intellij et cliquez sur "Open".
- Sélectionnez "mesparticipations-master" comme projet à ouvrir.
- Lancez l'application : faites un clique droit sur la classe "AspirateurdonneesApplication.java" (src/main/java/com.lee.aspirateurdonnees/AspirateurdonneesApplication.java) et puis sélectionnez "Run'AspirateurdonneesApplication'".
Vous devez obtenir plusieurs réponses dans la console dont la dernière est "Started AspirateurdonneesApplication...".
- Rendez vous sur votre navigateur et entrez l'adresse suivante : localhost:8080/cours
Vous pouvez aussi utiliser votre terminal et tapez la commande : curl localhost:8080/cours

-> Vous obtenez les données de la base H2 en csv : un fichier cours.csv se crée dans le dossier ressources (src/main/ressources).
Il contient :

1;cours;lee;apprenant;2018-01-01T08:30;2018-01-01T10:00;90;false  
2;conférence;business intelligence;organisation;2018-01-01T10:15;2018-01-01T11:45;90;true  
3;débat;le big data;animation;2018-01-02T08:30;2018-01-02T11:45;195;true  

Remarque :

Vous pouvez visualiser les données (créées dans AspirateurdonneesApplication.java) grace à la console de h2 qui se trouve a l'adresse http://localhost:8080/h2-console. Dans la partie "jdbc url", saisissez "jdbc:h2:mem:cours" pour configurer la connexion vers la base de données cours. Ensuite cliquez sur "Connect". Il vous est alors proposé une interface permettant de visualiser cette table (select * from cours;)
