package pm.truco.jogador;

import java.util.*;
import pm.truco.baralho.*;

public class JogadorRandomico extends Jogador {
	public Carta escolherCarta() {
		// escolher carta de acordo com criterio
		Random random = new Random();
		int i = random.nextInt(this.cartasNaMao.size());
		Carta c = this.cartasNaMao.get(i);
		this.cartasNaMao.remove(i);
		return c;
	}

	public boolean definirSePedeTruco() {
		Random random = new Random();
		float probabilidade = 0.1f;
		return random.nextFloat() < probabilidade;
	}

	public boolean definirSeAceitaTruco() {
		Random random = new Random();
		float probabilidade = 0.5f;
		return random.nextFloat() < probabilidade;
	}
}
