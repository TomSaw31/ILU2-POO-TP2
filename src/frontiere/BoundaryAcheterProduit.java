package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if(!controlAcheterProduit.verifierNomAcheteur(nomAcheteur)) {
			System.out.println("Je suis désolé " + nomAcheteur + " mais il faut être un habitant de notre village pour commercer ici.");
			return;
		}
		String produitAchat = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
		String[] vendeurs = controlAcheterProduit.rechercherVendeursProduit(produitAchat);
		if(vendeurs.length == 0) {
			System.out.println("Désolé, personne ne vend ce produit au marché");
			return;
		}
		//Ensuite il faut présenter tous les vendeurs qui peuvent répondre à la demande du client
		System.out.println("Chez quel commerçant voulez-vous acheter des fleurs ?");
		for(int i = 0; i < vendeurs.length; i++) {
			System.out.println((i + 1) + " - " + vendeurs[i]);
		}
		int vendeurChoisi;
		do {
			vendeurChoisi = Clavier.entrerEntier("");
		} while (vendeurChoisi > vendeurs.length || vendeurChoisi <= 0);
		
		
		 Clavier.entrerChaine("Chez quel commercant voulez-vous acheter des " + produitAchat + " ?");
		//client donne le produit qu’il est venu acheter.
		//Le client choisit à quel étal se rendre et procède à l’achat
		
	}
}
