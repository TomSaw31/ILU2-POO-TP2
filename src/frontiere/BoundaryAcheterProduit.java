package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierNom(nomAcheteur)) {
			System.out.println("Je suis désolé " + nomAcheteur
					+ " mais il faut être un habitant de notre village pour commercer ici.");
			return;
		}
		String produitAchat = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
		String[] vendeurs = controlAcheterProduit.rechercherVendeursProduit(produitAchat);
		if (vendeurs == null) {
			System.out.println("Désolé, personne ne vend ce produit au marché");
			return;
		}
		System.out.println("Chez quel commercant voulez-vous acheter des " + produitAchat + " ?");
		for (int i = 0; i < vendeurs.length; i++) {
			System.out.println((i + 1) + " - " + vendeurs[i]);
		}
		int vendeurChoisi;
		do {
			vendeurChoisi = Clavier.entrerEntier("");
		} while (vendeurChoisi > vendeurs.length || vendeurChoisi <= 0);

		String nomVendeur = vendeurs[vendeurChoisi - 1];
		if (!controlAcheterProduit.verifierNom(nomVendeur)) {
			System.out.println("Je suis désolé " + nomVendeur
					+ " mais il faut être un habitant de notre village pour commercer ici.");
		}
		System.out.println(nomAcheteur + " se déplace jusqu'à  l'étal du vendeur " + nomVendeur);
		System.out.println("Bonjour " + nomAcheteur);
		int quantiteAchat;
		do {
			quantiteAchat = Clavier.entrerEntier("Combien de " + produitAchat + " voulez-vous acheter ?");
		} while (quantiteAchat <= 0);

		int quantiteVendue = controlAcheterProduit.acheterProduit(nomVendeur, quantiteAchat);
		if (quantiteVendue == 0) {
			System.out.println(nomAcheteur + " veut acheter " + quantiteAchat + " " + produitAchat
					+ ", malheureusement il n'y en a plus !");
		} else if (quantiteVendue == quantiteAchat) {
			System.out
					.println(nomAcheteur + " achète " + quantiteAchat + " " + produitAchat + " à " + nomVendeur + ".");
		} else {
			System.out.println(nomAcheteur + " veut acheter " + quantiteAchat + " " + produitAchat
					+ ", malheureusement " + nomVendeur + " n'en a plus que " + quantiteVendue + ". " + nomAcheteur
					+ " achète tout le stock de " + nomVendeur + ".");
		}

	}
}
