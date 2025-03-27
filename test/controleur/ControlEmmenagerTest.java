package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlEmmenagerTest {
	private Village village;
	private Chef abraracourcix;
	private ControlEmmenager controlEmmenager;

	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlEmmenager = new ControlEmmenager(village);
	}

	@Test
	void testControlEmmenager() {
		assertNotNull(controlEmmenager, "Constructeur ne renvoie pas null");
	}

	@Test
	void testIsHabitant() {
		assertTrue(controlEmmenager.isHabitant("Abraracourcix"));
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		assertTrue(controlEmmenager.isHabitant("Bonemine"));
		controlEmmenager.ajouterDruide("Panoramix", 10, 1, 5);
		assertTrue(controlEmmenager.isHabitant("Panoramix"));
		assertFalse(controlEmmenager.isHabitant("Existe pas"));
	}

	@Test
	void testAjouterDruide() {
		assertFalse(controlEmmenager.isHabitant("Panoramix"));
		controlEmmenager.ajouterDruide("Panoramix", 10, 1, 5);
		assertTrue(controlEmmenager.isHabitant("Panoramix"));
	}

	@Test
	void testAjouterGaulois() {
		assertFalse(controlEmmenager.isHabitant("Bonemine"));
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		assertTrue(controlEmmenager.isHabitant("Bonemine"));
		assertFalse(controlEmmenager.isHabitant("PasBonemine"));
	}

	@Test
	void testAjouterBeaucoupDeGaulois() {
		for (int i = 0; i < 100; i++) {
			controlEmmenager.ajouterGaulois("GAULOIS_" + i, 10);
		}
		for (int i = 0; i < 100; i++) {
			if (i < 10) {
				assertTrue(controlEmmenager.isHabitant("GAULOIS_" + i));
			} else {
				assertFalse(controlEmmenager.isHabitant("GAULOIS_" + i));
			}
		}
	}
}
