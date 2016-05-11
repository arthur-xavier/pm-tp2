package pm.truco.jogador;

import java.util.*;
import pm.truco.baralho.*;

public class JogadorHumano extends Jogador {
	private void mostrarCartasNaMao() {
		System.out.println("Você tem as seguintes cartas na mão:");
		for (int i = 0; i < this.cartasNaMao.size(); i++) {
			System.out.println(i + " - " + this.cartasNaMao.get(i).toString());
		}
	}

	public Carta escolherCarta() {
		System.out.println();
		int escolhida = -1;
		Scanner reader = new Scanner(System.in);
		while (escolhida < 0 || escolhida >= this.cartasNaMao.size()) {
			System.out.println("Qual carta deseja jogar?");
			escolhida = reader.nextInt();
		}

		Carta c = this.cartasNaMao.get(escolhida);
		this.cartasNaMao.remove(escolhida);
		return c;
	}

	public boolean definirSePedeTruco() {
		this.mostrarCartasNaMao();
		int pediraTruco = 0;
		Scanner reader = new Scanner(System.in);

		while (pediraTruco != 1 && pediraTruco != 2) {
			System.out.println("Deseja pedir truco? 1 - Sim, 2 - Não");
			pediraTruco = reader.nextInt();
		}

		return pediraTruco == 1;
	}

	public boolean definirSeAceitaTruco() {
		int aceitouTruco = 0;
		Scanner reader = new Scanner(System.in);

		while (aceitouTruco != 1 && aceitouTruco != 2) {
			System.out.println("Deseja aceitar o truco? 1 - Sim, 2 - Não");
			aceitouTruco = reader.nextInt();
		}

		return aceitouTruco == 1;
	}
}
