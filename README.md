# Jeu des Pirates

Projet de Programmation Orientée Objet — UPSSITECH SRI 3A

## Description

Jeu de société de parcours en console opposant deux pirates : Jack Le Borgne et Bill Jambe de Bois. Chaque joueur avance à tour de rôle selon le résultat de deux dés à 6 faces sur un plateau de 30 cases. Le premier à atteindre la case 30 gagne, ou à défaut, celui qui survit à son adversaire.

Chaque pirate commence avec 5 points de vie. Tomber sur certaines cases spéciales peut faire gagner ou perdre des points de vie. Un joueur qui n'a plus de points de vie perd la partie.

## Cases spéciales

| Case | Type | Effet |
|------|------|-------|
| 7, 21 | Vol de Vie | +1 PV au joueur actif, -1 PV à l'adversaire |
| 11, 19 | Mine | -1 PV au joueur actif |
| 13, 27 | Roulette Russe | Téléporte le joueur sur une case aléatoire (1-30) |

## Structure du projet

```
├── Main.java              # Point d'entrée du programme
├── Jeu.java               # Logique principale de la partie
├── Joueur.java            # Classe joueur avec points de vie et position
├── Plateau.java           # Plateau de jeu avec 30 cases
├── Des.java               # Lancer de deux dés
├── Case.java              # Classe abstraite pour les cases
├── CaseNormale.java
├── CaseVolVie.java
├── CaseMine.java
├── CaseRouletteRusse.java
├── IAffichage.java        # Interface d'affichage
└── Affichage.java         # Implémentation console
```

## Lancer le projet

```bash
javac src/*.java -d bin
java -cp bin Main
```

## Exigences techniques

- Séparation modèle / affichage via l'interface `IAffichage`
- Utilisation de l'héritage, des classes abstraites, des interfaces et des énumérés
- Conformité SonarLint
