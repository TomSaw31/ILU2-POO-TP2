package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private Village village;
	private Chef abraracourcix;
	private ControlLibererEtal controlLibererEtal;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
	}
	
	@Test
	void testControlLibererEtal() {
		assertNotNull(controlTrouverEtalVendeur, "Constructeur ne renvoie pas null");
		assertNotNull(controlLibererEtal, "Constructeur ne renvoie pas null");
	}

	@Test
	void testIsVendeur() {
		assertFalse(controlLibererEtal.isVendeur("Jean"));
		Gaulois gaulois = new Gaulois("Jean",10);
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "fleurs", 10);
		assertTrue(controlLibererEtal.isVendeur("Jean"));
	}

	@Test
	void testLibererEtal() {
		Gaulois gaulois = new Gaulois("Jean",10);
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "fleurs", 10);
		String[] donneesEtal = controlLibererEtal.libererEtal("Jean");
		assertEquals(donneesEtal[0],"true");
		assertEquals(donneesEtal[1],"Jean");
		assertEquals(donneesEtal[2],"fleurs");
		assertEquals(donneesEtal[3],"10");
		assertEquals(donneesEtal[4],"0");
		
	}

}
