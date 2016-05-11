package pm.truco.partida;

import pm.truco.jogador.*;

public class PartidaBuilder {

	public Partida criarTrucoDoisJogadores() {
		Partida partida = new Partida();

		Jogador vc = JogadorFactory.criarJogador(Jogador.TipoJogador.HUMANO, "Voce", 1);
		Jogador comp = JogadorFactory.criarJogador(Jogador.TipoJogador.RANDOMICO, "Computador", 2);

		partida.adicionarJogador(comp);
		partida.adicionarJogador(vc);
		partida.jogar();

    return partida;
	}
}
