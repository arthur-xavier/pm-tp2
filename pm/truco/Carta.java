import java.lang.*;

public class Carta {
	private char numero;
	private String naipe;

	Carta(char numero, String naipe) {
		this.numero = numero;
		this.naipe = naipe;
	}

	public void setNumero(char numero) {
		this.numero = Character.toLowerCase(numero);
	}
	
	public void setNaipe(String naipe) {
		this.naipe = naipe.toLowerCase();
	}

	public char getNumero() {
		return this.numero;
	}

	public String getNaipe() {
		return this.naipe;
	}
}
