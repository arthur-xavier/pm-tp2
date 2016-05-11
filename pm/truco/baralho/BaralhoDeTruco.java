package pm.truco.baralho;

import java.util.*;

public class BaralhoDeTruco implements Baralho {
	private static BaralhoDeTruco instance = null;

	private Stack<Carta> cartas;
	private Hashtable<Carta, Integer> valores;

  public Stack<Carta> getCartas() {
    return cartas;
  }

  public String[] getNaipesValidos() {
    return new String[]{"♠", "♦", "♥", "♣"};
  }
  public char[] getNumerosValidos() {
    return new char[]{'2', '3', '4', '5', '6', '7', 'Q', 'J', 'K', 'A'};
  }

	private int getValorManilha(Carta c) {
		if (c.getNumero() == '4' && c.getNaipe().equals("♣")) {
			return 13;
		} else if (c.getNumero() == '7' && c.getNaipe().equals("♥")) {
			return 12;
		} else if (c.getNumero() == 'A' && c.getNaipe().equals("♠")) {
			return 11;
		} else if (c.getNumero() == '7' && c.getNaipe().equals("♦")) {
			return 10;
		}
		return -1;
	}

	private void inicializarValores() {
		this.valores = new Hashtable<Carta, Integer>();
		char[] ordem = {'4', '5', '6', '7', 'Q', 'J', 'K', 'A', '2', '3'};

		for (Carta c: this.cartas) {
			int valorManilha = this.getValorManilha(c);
			if (valorManilha > -1) {
				this.valores.put(c, valorManilha);
				continue;
			}

			for (int i = 0; i < ordem.length; i++) {
				if (c.getNumero() == ordem[i]) {
					this.valores.put(c, i);
					break;
				}
			}
		}
	}

	public List<Carta> retirarCartas(int n) {
		List<Carta> retiradas = new ArrayList<Carta>();

		for (int i = 0; i < n; i++) {
			retiradas.add(this.cartas.pop());
		}

		return retiradas;
	}

	private void inicializarCartas() {
		this.cartas = new Stack<Carta>();

    String[] naipesValidos = getNaipesValidos();
    char[] numerosValidos = getNumerosValidos();

		for (int i = 0; i < numerosValidos.length; i++) {
			for (int j = 0; j < naipesValidos.length; j++) {
				this.cartas.push(new Carta(numerosValidos[i], naipesValidos[j]));
			}
		}

		Collections.shuffle(this.cartas);
	}

	private BaralhoDeTruco() {
		this.inicializarCartas();
		this.inicializarValores();
	}

	public int getValorCarta(Carta c) {
		return this.valores.get(c);
	}

	public static BaralhoDeTruco getInstance() {
		if (instance == null) {
			instance = new BaralhoDeTruco();
		}

		return instance;
	}
}
