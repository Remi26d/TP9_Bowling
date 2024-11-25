package bowling;

public class Lancer {
	private final int quillesAbattues;

	public Lancer(int quillesAbattues) {
		if (quillesAbattues < 0 || quillesAbattues > 10) {
			throw new IllegalArgumentException("Nombre de quilles invalide.");
		}
		this.quillesAbattues = quillesAbattues;
	}

	public int getQuillesAbattues() {
		return quillesAbattues;
	}
}
