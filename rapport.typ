// ─── Configuration générale ───────────────────────────────────────────────────

#set document(title: "Rapport — Jeu des Pirates", author: "Mohamed Aziz Sahli")

#set page(
  paper: "a4",
  margin: (top: 2.5cm, bottom: 2.5cm, left: 2.5cm, right: 2.5cm),
  footer: context {
    let current = counter(page).get().first()
    let total   = counter(page).final().first()
    if current > 1 [
      #set text(size: 9pt, fill: luma(120))
      #grid(
        columns: (1fr, 1fr),
        align(left)[Mohamed Aziz Sahli],
        align(right)[Page #current / #total],
      )
      #line(length: 100%, stroke: 0.4pt + luma(180))
    ]
  },
)

#set text(font: "Linux Biolinum", size: 11pt, lang: "fr")
#set heading(numbering: "1.")
#set par(justify: true, leading: 0.75em)

// ─── Page de garde ────────────────────────────────────────────────────────────

#page(footer: none)[
  #v(3cm)

  #align(center)[
    #text(size: 13pt, fill: luma(100), tracking: 2pt)[
      UPSSITECH — 3A SRI \
      Programmation Orientée Objet
    ]

    #v(1.5cm)
    #line(length: 60%, stroke: 1.5pt)
    #v(1cm)
    #text(size: 28pt, weight: "bold")[Le jeu des Pirates]
    #v(0.5cm)
    #text(size: 14pt, fill: luma(80))[Rapport de projet Java — Conception UML]
    #v(1cm)
    #line(length: 60%, stroke: 1.5pt)
    #v(2.5cm)

    #text(size: 12pt)[
      *Auteur :* Mohamed Aziz Sahli \
    ]

    #v(0.5cm)

    #text(size: 11pt, fill: luma(100))[
      Année universitaire 2025–2026
    ]
  ]

  #v(1fr)

]

// ─── Table des matières ───────────────────────────────────────────────────────

#outline(
  title: "Table des matières",
  indent: auto,
  depth: 2,
)

#pagebreak()

// ─── 1. Introduction ──────────────────────────────────────────────────────────

= Introduction

Ce rapport présente la conception et l'implémentation du jeu des Pirates, réalisé dans le cadre du cours de programmation orientée objet. Le jeu oppose deux pirates : Jack Le Borgne et Bill Jambe de Bois sur un plateau de 30 cases. Chaque joueur lance deux dés à tour de rôle et avance son pion en conséquence. Le premier à atteindre la case 30, ou le dernier à survivre, remporte la partie.

Le développement suit une architecture séparant strictement la logique du jeu de la couche d'affichage, qui implémente l'interface `IAffichage`. Les techniques mises en œuvre incluent l'héritage, les classes abstraites, les interfaces et les énumérés.

// ─── 2. Diagramme de classes ──────────────────────────────────────────────────

= Diagramme de classes

Le diagramme de classes ci-dessous modélise l'ensemble des entités du projet ainsi que leurs relations : héritage, associations et dépendances.

#v(0.5cm)
#figure(
  image("diagrammes/diagramme_classe_reduit.png", width: 85%),
  caption: [
    Diagramme de classes simplifié
  ],
)
#v(0.5cm)

Les points clés de l'architecture sont les suivants :

- La classe abstraite `Case` est étendue par `CaseNormale`, `CaseVolVie`, `CaseMine` et `CaseRouletteRusse`.
- L'interface `IAffichage` est implémentée par la classe `Affichage`, ce qui découple totalement l'affichage du modèle.
- La classe `Jeu` organise la partie en s'appuyant sur `Plateau`, `Des` et un tableau de `Joueur`.
- L'énuméré `Couleur` identifie le pion de chaque joueur (ROUGE ou BLEU).

#v(0.5cm)
#figure(
  image("diagrammes/diagramme_classe.png", width: 100%),
  caption: [
    Diagramme de classes
  ],
)
#pagebreak()

// ─── 3. Diagramme de séquence système ────────────────────────────────────────

= Diagramme de séquence système

Le diagramme de séquence système décrit les interactions entre l'utilisateur et le système lors du déroulement d'un tour de jeu, sans entrer dans le détail des classes internes.

#v(0.5cm)
#figure(
  image("diagrammes/sequence_systeme.svg", width: 85%),
  caption: [
    Diagramme de séquences système
  ],
)
#v(0.5cm)

Le scénario principal est le suivant : le système lance les dés, déplace le joueur actif, déclenche l'action de la case atteinte, puis vérifie les conditions de fin de partie. Ce cycle se répète jusqu'à ce qu'un joueur gagne.

// ─── 4. Diagrammes de séquence détaillés ─────────────────────────────────────

= Diagrammes de séquence détaillés

Cette section présente les diagrammes de séquence détaillés pour les cases spéciales. Ces diagrammes montrent les appels entre objets à l'intérieur du système.

== Case Vol de Vie

Lorsqu'un joueur atterrit sur une case Vol de Vie (cases 7 et 21), il gagne un point de vie et son adversaire en perd un.

#v(0.5cm)
#figure(
  image("diagrammes/sequence_case_vol_vie.svg", width: 85%),
  caption: [
    Diagramme de séquence détaillé — Case Vol de Vie
  ],
)
#v(0.5cm)

== Case Mine

Lorsqu'un joueur atterrit sur une case Mine (cases 11 et 19), il perd deux point de vie. Si ses points de vie tombent à zéro ou en dessous, la partie se termine.

#v(0.5cm)
#figure(
  image("diagrammes/sequence_case_mine.svg", width: 85%),
  caption: [
    Diagramme de séquence détaillé — Case Mine
  ],
)
#v(0.5cm)

== Case Roulette Russe

Lorsqu'un joueur atterrit sur une case Roulette Russe (cases 13 et 27), sa position est remplacée par un entier aléatoire compris entre 1 et 30.

#v(0.5cm)
#figure(
  image("diagrammes/sequence_case_roulette_russe.svg", width: 85%),
  caption: [
    Diagramme de séquence détaillé — Case Roulette Russe
  ],
)
#v(0.5cm)

// ─── 5. Description des cases spéciales ──────────────────────────────────────

= Description des cases spéciales

#table(
  columns: (auto, 1fr, 1fr),
  inset: 8pt,
  stroke: 0.5pt + luma(200),
  fill: (col, row) => if row == 0 { luma(230) } else if calc.odd(row) { luma(250) } else { white },
  align: (col, row) => if col == 0 { center } else { left },
  [*Cases*], [*Type*], [*Effet*],
  [7, 21],   [Vol de Vie],      [+1 PV au joueur actif, -1 PV à l'adversaire],
  [11, 19],  [Mine],            [-2 PV au joueur actif],
  [13, 27],  [Roulette Russe],  [Téléporte le joueur sur une case aléatoire entre 1 et 30],
)

// ─── 6. Conclusion ────────────────────────────────────────────────────────────

= Conclusion

Ce projet a permis de mettre en pratique les principes fondamentaux de la programmation orientée objet : encapsulation, héritage, polymorphisme et séparation des responsabilités. L'architecture retenue, inspirée du patron MVC, garantit que toute logique d'affichage reste confinée à la classe `Affichage`, ce qui facilite la maintenance et l'évolution du code.
