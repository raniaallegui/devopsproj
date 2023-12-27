Projet DevOps
Ce projet a été créé dans le but d'automatiser le processus de développement, de test et de déploiement d'applications en utilisant des pratiques DevOps modernes.

Technologies utilisées
Git
Docker
Maven
Nexus
JUnit
SonarQube
Mockito
Kubernetes
Configuration du Projet
Prérequis
Assurez-vous d'avoir installé localement les éléments suivants :

Git
Docker
Maven
Kubernetes (minikube, kubectl, etc.)
Installation et Exécution
Clonage du Repository :

bash
Copy code
git clone https://github.com/votre-utilisateur/projet-devops.git
cd projet-devops
Construction de l'environnement Docker :

bash
Copy code
docker-compose build
docker-compose up -d
Configuration de Nexus et de SonarQube :
Accédez à l'interface web de Nexus à l'adresse http://localhost:8081 et configurez vos dépôts.
De même, accédez à l'interface web de SonarQube à http://localhost:9000 et configurez les paramètres nécessaires.

Exécution des tests :

bash
Copy code
mvn clean test
Analyse du code avec SonarQube :

bash
Copy code
mvn sonar:sonar
Déploiement sur Kubernetes :

bash
Copy code
kubectl apply -f kubernetes/config.yaml
kubectl apply -f kubernetes/deployment.yaml
Accès à l'application déployée :
Une fois le déploiement terminé, accédez à l'application en utilisant l'URL fournie par Kubernetes.

Contributions et Remarques
N'hésitez pas à contribuer à ce projet en créant des pull requests ou en signalant des problèmes (issues). Toute contribution est la bienvenue !
