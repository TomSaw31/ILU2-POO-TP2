package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village;
	private Chef abraracourcix;
	private ControlPrendreEtal controlPrendreEtal;
	private ControlVerifierIdentite controlVerifierIdentite;

	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite,village);
	}

	@Test
	void testControlPrendreEtal() {
		assertNotNull(controlVerifierIdentite, "Constructeur ne renvoie pas null");
		assertNotNull(controlPrendreEtal, "Constructeur ne renvoie pas null");
	}

	@Test
	void testResteEtals() {
		assertTrue(controlPrendreEtal.resteEtals());
		Gaulois gaulois;
		for (int i = 0; i < 5; i++) {
			gaulois = new Gaulois(String.valueOf(i),10);
			village.ajouterHabitant(gaulois);
			village.installerVendeur(gaulois, "fleurs", 5);
		}
		assertFalse(controlPrendreEtal.resteEtals());
	}

	@Test
	void testPrendreEtal() {
		Gaulois gaulois;
		for (int i = 0; i < 5; i++) {
			gaulois = new Gaulois(String.valueOf(i),10);
			village.ajouterHabitant(gaulois);
			assertEquals(i, controlPrendreEtal.prendreEtal(gaulois.getNom(), "fleurs", 5));
		}
	}

	@Test
	void testVerifierIdentite() {
		assertFalse(controlPrendreEtal.verifierIdentite("Jean"));
		Gaulois gaulois = new Gaulois("Jean",10);
		village.ajouterHabitant(gaulois);
		assertTrue(controlPrendreEtal.verifierIdentite("Jean"));
		assertFalse(controlPrendreEtal.verifierIdentite("Inconnu"));
	}

}
