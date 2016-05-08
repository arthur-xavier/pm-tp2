import java.util.*;

public abstract class Baralho {
	protected String[] naipesValidos;
	protected char[] numerosValidos;
	protected Stack<Carta> cartas;
	protected static final String[] todosNaipes = {"paus",
		"ouros",
		"copas",
		"espadas"};

	protected static final char[] todosNumeros = {2, 3, 4, 5, 
		6, 7, 8, 9, 'j', 'q', 'k', 'a'};
	
	public void setNaipesValidos(String[] naipesValidos) {
		this.naipesValidos = naipesValidos;
	}

	public void setNumerosValidos(char[] numerosValidos) {
		this.numerosValidos = numerosValidos;
	}

	public String[] getNaipesValidos() {
		return this.naipesValidos;
	}

	public char[] getNumerosValidos() {
		return this.numerosValidos;
	}

	protected void inicializarCartas() {
		String[] naipes;
		if (this.naipesValidos == null) {
			System.out.println("TODOS OS NAIPES CONSIDERADOS");
			naipes = todosNaipes;
		} else {
			naipes = naipesValidos;
		}

		char[] numeros;
		if (this.numerosValidos == null) {
			System.out.println("TODOS OS NUMEROS CONSIDERADOS");
			numeros = todosNumeros;
		} else {
			numeros = numerosValidos;
		}

		for (int i = 0; i < numeros.length; i++) {
			for (int j = 0; j < naipes.length; j++) {
				this.cartas.push(new Carta(numeros[i], naipes[j]));
			}
		}

		Collections.shuffle(this.cartas);		
	}

	public Carta[] retirarCartas(int n) {
		Carta[] retiradas = new Carta[n];

		for (int i = 0; i < n; i++) {
			retiradas[i] = this.cartas.pop();
		}

		return retiradas;
	}
}
