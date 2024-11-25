package bowling;

import java.util.List;

public class CalculateurScore {

	public static int calculerBonusPourStrike(List<Tour> tours, int tourIndex) {
		int bonus = 0;

		// Bonus du premier tour suivant
		if (tourIndex + 1 < tours.size()) {
			Tour tourSuivant = tours.get(tourIndex + 1);
			bonus += tourSuivant.sommeDesQuillesPremierDeuxLancers();

			// Si le premier tour suivant est aussi un strike, inclure le premier lancer du tour suivant
			if (tourSuivant.estStrike() && tourIndex + 2 < tours.size()) {
				bonus += tours.get(tourIndex + 2).sommeDesQuillesPremierLancer();
			}
		}

		return bonus;
	}

	public static int calculerBonusPourSpare(List<Tour> tours, int tourIndex) {
		// Bonus : premier lancer du tour suivant
		if (tourIndex + 1 < tours.size()) {
			return tours.get(tourIndex + 1).sommeDesQuillesPremierLancer();
		}
		return 0; // Pas de tour suivant
	}
}
