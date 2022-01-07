#Performance des employés
Created by ruben on 07/01/2022

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.
     
## Scenario: Calculer l'indicateur de performance d'un employé commercial ayant un CA traité inférieur au CA objectif
* Soit le commercial "Jhon" "Doe" ayant le matricule "C2434", un chiffre d'affaire traité de "4600" euros et avec un objectif de "5000" euros.
* Lorsque je calcule son indice de performance,
* Alors son indice de performance est égal à "1".

## Scenario: Calculer l'indicateur de performance d'un employé commercial ayant un CA traité null
* Soit le commercial "Jhon" "Doe" ayant le matricule "C12345", un chiffre d'affaire traité de "" euros et avec un objectif de "5000" euros.
* Lorsque je calcule son indice de performance,
* Alors je veux obtenir une erreur, avec le message suivant : "Le chiffre d'affaires traité ne peut être négatif ou null !".

## Scenario: Calculer l'indicateur de performance d'un employé commercial ayant un matricule commençant par "M"
* Soit le commercial "Jhon" "Doe" ayant le matricule "M12345", un chiffre d'affaire traité de "3000" euros et avec un objectif de "2000" euros.
* Lorsque je calcule son indice de performance,
* Alors je veux obtenir une erreur, avec le message suivant : "Le matricule ne peut être null et doit commencer par un C !".