package bowling;

import java.util.ArrayList;
import java.util.List;

public class Tour {
	private final List<Lancer> lancers;

	public Tour() {
		this.lancers = new ArrayList<>();
	}

	public void ajouterLancer(Lancer lancer) {
		if (estComplet()) {
			throw new IllegalStateException("Le tour est déjà complet.");
		}
		lancers.add(lancer);
	}

	public boolean estComplet() {
		if (lancers.size() == 0) return false;

		// Si c'est un strike et pas le dernier tour
		if (lancers.size() == 1 && lancers.get(0).getQuillesAbattues() == 10) {
			return true; // Strike (complet sauf pour le dernier tour)
		}

		// Dernier tour avec spare ou strike
		if (lancers.size() == 3) {
			return true; // 3 lancers maximum pour le dernier tour
		}

		// Si ce n'est pas le dernier tour, seulement 2 lancers sont permis
		return lancers.size() == 2;
	}

	public boolean estStrike() {
		return lancers.size() > 0 && lancers.get(0).getQuillesAbattues() == 10;
	}

	public boolean estSpare() {
		return lancers.size() == 2 && sommeDesQuilles() == 10;
	}

	public int calculerScore() {
		return sommeDesQuilles();
	}

	public int sommeDesQuilles() {
		return lancers.stream().mapToInt(Lancer::getQuillesAbattues).sum();
	}

	public int sommeDesQuillesPremierDeuxLancers() {
		if (lancers.size() >= 2) {
			return lancers.get(0).getQuillesAbattues() + lancers.get(1).getQuillesAbattues();
		} else if (lancers.size() == 1) {
			return lancers.get(0).getQuillesAbattues();
		}
		return 0; // Pas de lancers enregistrés
	}

	public int sommeDesQuillesPremierLancer() {
		if (lancers.size() > 0) {
			return lancers.get(0).getQuillesAbattues();
		}
		return 0; // Aucun lancer
	}

	public int getNombreDeLancers() {
		return lancers.size();
	}
}
