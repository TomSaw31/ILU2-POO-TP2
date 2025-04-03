package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private Chef abraracourcix;
	private ControlAfficherVillage controlAfficherVillage;
	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlAfficherVillage = new ControlAfficherVillage(village);
	}
	@Test
	void testControlAfficherVillage() {
		assertNotNull(controlAfficherVillage, "Constructeur ne renvoie pas null");
	}

	@Test
	void testDonnerNomsVillageois() {
		Gaulois gaulois = new Gaulois("Jean",10);
		village.ajouterHabitant(gaulois);
		Gaulois gaulois2 = new Gaulois("Pierre",10);
		village.ajouterHabitant(gaulois2);
		String[] noms = controlAfficherVillage.donnerNomsVillageois();
		assertEquals(noms[0], "Abraracourcix");
		assertEquals(noms[1], "Jean");
		assertEquals(noms[2], "Pierre");
	}

	@Test
	void testDonnerNomVillage() {
		assertEquals("le village des irréductibles", controlAfficherVillage.donnerNomVillage());
		assertNotEquals("le village gaulois", controlAfficherVillage.donnerNomVillage());
	}

	@Test
	void testDonnerNbEtals() {
		assertEquals(5, controlAfficherVillage.donnerNbEtals());
		assertNotEquals(0, controlAfficherVillage.donnerNbEtals());
	}

}
