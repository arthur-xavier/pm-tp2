package pm.truco;

import pm.truco.partida.*;

public class Main {

	public static void main(String[] args) {
		System.out.println("+-------------------------------------+");
		System.out.println("|----------- TRUCO MINEIRO -----------|");
		System.out.println("+-------------------------------------+");
		System.out.println("|                                     |");
		System.out.println("|Lembre-se: Você pertence à equipe 2!!|");
		System.out.println("+-------------------------------------+");

    PartidaBuilder builder = new PartidaBuilder();
    Partida partida = builder.criarTrucoDoisJogadores();
    partida.jogar();
	}
}
