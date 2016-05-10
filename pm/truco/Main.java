
public class Main {

	public static void main(String[] args) {
		Truco t = new Truco();
		Jogador comp = new JogadorRandomico();
		comp.setNome("Computador");
		comp.setEquipe(1);
		Jogador vc = new JogadorHumano();
		vc.setNome("Voce");
		vc.setEquipe(2);

		t.adicionarJogador(comp);
		t.adicionarJogador(vc);
		t.jogar();


	}
}
