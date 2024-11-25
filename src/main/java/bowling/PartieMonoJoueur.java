package bowling;

import java.util.ArrayList;
import java.util.List;

public class PartieMonoJoueur {
	private final List<Tour> tours;
	private int tourCourant;

	public PartieMonoJoueur() {
		this.tours = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			tours.add(new Tour());
		}
		this.tourCourant = 0;
	}

	public boolean enregistreLancer(int nombreDeQuillesAbattues) {
		if (estTerminee()) {
			throw new IllegalStateException("La partie est terminée.");
		}

		Tour tour = tours.get(tourCourant);
		tour.ajouterLancer(new Lancer(nombreDeQuillesAbattues));

		if (tour.estComplet()) {
			tourCourant++;
		}

		return !tour.estComplet();
	}

	public int score() {
		int score = 0;
		for (int i = 0; i < tours.size(); i++) {
			Tour tour = tours.get(i);
			score += tour.calculerScore();

			if (tour.estStrike() && i < 9) {
				score += CalculateurScore.calculerBonusPourStrike(tours, i);
			} else if (tour.estSpare() && i < 9) {
				score += CalculateurScore.calculerBonusPourSpare(tours, i);
			}
		}
		return score;
	}

	public boolean estTerminee() {
		return tourCourant >= 10;
	}

	public int numeroTourCourant() {
		return estTerminee() ? 0 : tourCourant + 1;
	}

	public int numeroProchainLancer() {
		if (estTerminee()) {
			return 0;
		}
		return tours.get(tourCourant).getNombreDeLancers() + 1;
	}
}
