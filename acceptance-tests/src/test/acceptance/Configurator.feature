Feature: Fonctionnalités de la page configurateur

  Scenario: Vérification de l'url du bouton commander
    Given je suis sur le configurateur
    Then le lien du bouton commander doit être "https://www.tesla.com/fr_fr/models/design"

  Scenario: Vérification du prix affiché par défaut
    Given je suis dans la partie design du configurateur
    Then le prix affiché par défaut est "847 € /mois" et "LOA"

  Scenario: Vérification des différents prix pour les modèles Plaid+ et Plaid
    Given je suis dans la partie design du configurateur
    Then Lorsque je sélectionne le modèle Plaid+, le prix en LOA est à 1441€/mois et 108€/mois d'économies de carburant estimées et un montant total avec achat au terme du contrat de 157 097 €
    And Lorsque je sélectionne le modèle Plaid, le prix en LOA est à 1203€/mois et 108€/mois d'économies de carburant estimées et un montant total avec achat au terme du contrat de 134 495 €