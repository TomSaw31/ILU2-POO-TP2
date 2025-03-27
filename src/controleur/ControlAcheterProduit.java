package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public int acheterProduit(String nomVendeur, int quantite) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		if(etal != null) {
			return etal.acheterProduit(quantite);
		}
		return -1;
	}
	
	public boolean verifierNom(String nom) {
		return controlVerifierIdentite.verifierIdentite(nom);
	}
	
	public String[] rechercherVendeursProduit(String produitAchat) {
		Gaulois[] vendeurs = village.rechercherVendeursProduit(produitAchat);
		if(vendeurs == null) {
			return null;
		}
		String[] nomVendeurs = new String[vendeurs.length];
		for(int i = 0; i < nomVendeurs.length; i++) {
			nomVendeurs[i] = vendeurs[i].getNom();
		}
		return nomVendeurs;
	}
}
