public class BaralhoDeTruco extends Baralho {
	private static BaralhoDeTruco instance = null;
	private String[] naipesValidos = {"paus",
		"ouros",
		"copas",
		"espadas"};
	
	private char[] numerosValidos = {1, 2, 3, 4, 5, 6, 7,
		'q', 'k', 'a'};

	private BaralhoDeTruco() {
		this.inicializarCartas();
	}
	
	public static BaralhoDeTruco getInstance() {
		if (instance == null) {
			instance = new BaralhoDeTruco();
		}

		return instance;
	}
}
