import java.lang.*;
import java.lang.Character;

public class Carta {
	private char numero;
	private String naipe;

	Carta(char numero, String naipe) {
		this.numero = numero;
		this.naipe = naipe;
	}

	@Override
	public int hashCode() {
		int result = Character.getNumericValue(this.naipe.charAt(0))*1000;
		result += Character.getNumericValue(this.numero);
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (!(o instanceof Carta)) {
			return false;
		}

		Carta carta = (Carta) o;
		return carta.getNaipe().equals(this.naipe) 
			&& carta.getNumero() == this.numero;
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

	public String toString() {
		return this.numero + " de " + this.naipe;
	}
}
