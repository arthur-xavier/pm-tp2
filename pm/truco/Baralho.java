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


}
