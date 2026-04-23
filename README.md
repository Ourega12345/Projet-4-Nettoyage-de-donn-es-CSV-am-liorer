# Projet-4-Nettoyage-de-donn-es-CSV-am-liorer

#  Nettoyeur de Fichiers CSV en Java

##  Description

Ce projet est une application Java simple permettant de **nettoyer automatiquement un fichier CSV**.

L'utilisateur sélectionne un fichier via une interface graphique, puis le programme :

* lit le fichier CSV
* nettoie chaque cellule
* génère un nouveau fichier propre

---

##  Fonctionnalités

*  Sélection de fichier via explorateur (Windows / Mac / Linux)
*  Lecture ligne par ligne du fichier CSV
*  Nettoyage des données :

  * Suppression des espaces inutiles
  * Conversion en MAJUSCULES
  * Remplacement des valeurs manquantes par `VALEUR_MANQUANTE`
*  Sauvegarde automatique du fichier nettoyé

---

##  Structure du projet

```
src/
│── App.java                  # Point d’entrée du programme
│── GestionnaireFichier.java  # Gestion lecture / écriture / sélection fichier
│── NettoyeurDonnees.java     # Logique de nettoyage des données
```

---

##  Utilisation

### 1. Compiler le projet

```bash
javac src/*.java
```

### 2. Lancer le programme

```bash
java -cp src App
```

---

##  Fonctionnement

1. L'utilisateur sélectionne un fichier `.csv`
2. Le programme lit toutes les lignes
3. Chaque cellule est traitée :

   * trim()
   * mise en majuscule
   * gestion des valeurs vides
4. Un nouveau fichier est généré avec le suffixe :

```
_nom_du_fichier_nettoye.csv
```

---

##  Exemple

### Entrée :

```
nom, age, ville
alice, 25, montreal
bob, , toronto
```

### Sortie :

```
NOM,AGE,VILLE
ALICE,25,MONTREAL
BOB,VALEUR_MANQUANTE,TORONTO
```

---

## Concepts utilisés

* Java I/O (`BufferedReader`, `FileWriter`)
* `JFileChooser` pour interface graphique
* Manipulation de chaînes (`String`)
* Listes (`ArrayList`)
* Gestion des exceptions (`try-with-resources`)

---

## Limitations

* Le séparateur CSV utilisé est la virgule `,`
* Ne gère pas les cas complexes avec guillemets (CSV avancé)

---

##  Auteur
### Dago Ourega 
Projet réalisé dans le cadre d’un apprentissage en :

* Programmation Java
* Nettoyage de données (Data Cleaning)
* Préparation de données pour analyse

---

##  Améliorations possibles

* Support des fichiers volumineux
* Interface graphique complète
* Gestion avancée des formats CSV
* Ajout de logs et validation des données

---
