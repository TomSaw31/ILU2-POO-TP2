package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	private Village village;
	private Chef abraracourcix;
	private ControlAfficherMarche controlAfficherMarcheTest;
	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlAfficherMarcheTest = new ControlAfficherMarche(village);
	}
	
	@Test
	void testControlAfficherMarche() {
		assertNotNull(controlAfficherMarcheTest, "Constructeur ne renvoie pas null");
	}

	@Test
	void testDonnerInfosMarche() {
		assertEquals(controlAfficherMarcheTest.donnerInfosMarche().length,0);
		Gaulois gaulois = new Gaulois("Jean",5);
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "fleurs", 10);
		String[] marche = controlAfficherMarcheTest.donnerInfosMarche();
		assertEquals(marche[0], "Jean");
		assertEquals(marche[1], "10");
		assertEquals(marche[2],"fleurs");
		gaulois = new Gaulois("Pierre",5);
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "boucliers", 7);
		marche = controlAfficherMarcheTest.donnerInfosMarche();
		assertEquals(marche[0], "Jean");
		assertEquals(marche[1], "10");
		assertEquals(marche[2],"fleurs");
		assertEquals(marche[3], "Pierre");
		assertEquals(marche[4], "7");
		assertEquals(marche[5],"boucliers");
	}

}
