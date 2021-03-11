Feature: Fonctionnalités de ma page d'accueil
	Scenario: Vérification du titre et de la description
		Given je suis sur la homepage
		Then le titre doit être "Voitures électriques, énergie solaire et propre | Tesla France"
		And la description contient "Tesla accélère la transition mondiale vers une énergie durable en proposant des véhicules électriques, des panneaux solaires et des solutions intégrées d'énergie renouvelable pour les particuliers et les entreprises."

	Scenario: Vérification des punchlines
		Given je suis sur la homepage
		Then La punchline 1 est "Model 3"
		And La punchline 2 est "Model S"
		And La punchline 3 est "Model X"
		And La punchline 4 est "Model Y"
		And La punchline 5 est "Systèmes d'énergie solaire et Powerwalls"

	Scenario: Vérification des titres des liens et de leurs urls
		Given je suis sur la homepage
		Then Le lien 1 à pour titre "Model S" et pour lien "https://www.tesla.com/fr_fr/models"
		And Le lien 2 à pour titre "Model 3" et pour lien "https://www.tesla.com/fr_fr/model3"
		And Le lien 3 à pour titre "Model X" et pour lien "https://www.tesla.com/fr_fr/modelx"
		And Le lien 4 à pour titre "Model Y" et pour lien "https://www.tesla.com/fr_fr/modely"
		And Le lien 5 à pour titre "Powerwall" et pour lien "https://www.tesla.com/fr_fr/powerwall"
		And Le lien 6 à pour titre "Recharger" et pour lien "https://www.tesla.com/fr_fr/charging"



#	Il existe plusieurs punchlines (h1) parmi lesquels ces 5 titres important: La première : Model 3, la seconde: Model S, la troisième: Model X, la quatrième: Model Y, la cinquième: Systèmes d'énergie solaire et Powerwalls
#	Le menu tout en haut contient 6 liens (hors Shop et Compte Tesla). Le titre des liens: Model S, Model 3, Model X, Model Y, Powerwall, Recharger. Ils permettent d'aller sur les urls suivantes: https://www.tesla.com/fr_FR/models, https://www.tesla.com/fr_FR/model3, https://www.tesla.com/fr_FR/modelx, https://www.tesla.com/fr_FR/modely, https://www.tesla.com/fr_fr/powerwall, https://www.tesla.com/fr_FR/charging
#	Un "burger menu" à droite de l'écran permet d'accéder à différents liens: Véhicules disponibles, Véhicules d'occasion, Reprise, Cybertruck, Roadster, Energie, Essais, Flottes et entreprises, Nous trouver, Evénements, Assistance
