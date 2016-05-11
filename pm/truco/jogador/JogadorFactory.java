package pm.truco.jogador;

public class JogadorFactory {

	public static Jogador criarJogador(Jogador.TipoJogador tipo, String nome, int equipe) {
    Jogador jogador;

    switch(tipo) {
      case RANDOMICO:
        jogador = new JogadorRandomico();
        break;
      case HUMANO:
      default:
        jogador = new JogadorHumano();
        break;
    }

    jogador.setNome(nome);
    jogador.setEquipe(equipe);

    return jogador;
	}
}
