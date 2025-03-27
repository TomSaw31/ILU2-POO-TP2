package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private Village village;
	private Chef abraracourcix;
	private ControlAcheterProduit controlAcheterProduit;
	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlAcheterProduit = new ControlAcheterProduit(new ControlVerifierIdentite(village), new ControlTrouverEtalVendeur(village),village);
	}

	@Test
	void testControlAcheterProduit() {
		assertNotNull(controlAcheterProduit, "Constructeur ne renvoie pas null");
	}

	@Test
	void testAcheterProduit() {
		Gaulois gaulois = new Gaulois("Jean",10);
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "fleurs", 10);
		assertEquals(0,controlAcheterProduit.acheterProduit("Jean", 0));
		assertEquals(2,controlAcheterProduit.acheterProduit("Jean", 2));
		assertEquals(8,controlAcheterProduit.acheterProduit("Jean", 11));
		assertEquals(-1,controlAcheterProduit.acheterProduit("Inconnu", 1));
	}

	@Test
	void testVerifierNom() {
		Gaulois gaulois = new Gaulois("Jean",10);
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "fleurs", 10);
		assertTrue(controlAcheterProduit.verifierNom("Jean"));
		assertFalse(controlAcheterProduit.verifierNom("Inconnu"));
	}

	@Test
	void testRechercherVendeursProduit() {
		Gaulois gaulois = new Gaulois("Jean",10);
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "fleurs", 10);
		assertNull(controlAcheterProduit.rechercherVendeursProduit("ordinateurs"));
		String[] nomVendeurs = new String[1];
		nomVendeurs[0] = "Jean";
		assertArrayEquals(nomVendeurs,controlAcheterProduit.rechercherVendeursProduit("fleurs"));
		Gaulois gaulois2 = new Gaulois("Pierre",10);
		village.ajouterHabitant(gaulois2);
		village.installerVendeur(gaulois2, "fleurs", 10);
		String[] nomVendeurs2 = new String[2];
		nomVendeurs2[0] = "Jean";
		nomVendeurs2[1] = "Pierre";
		assertArrayEquals(nomVendeurs2,controlAcheterProduit.rechercherVendeursProduit("fleurs"));
	}

}
