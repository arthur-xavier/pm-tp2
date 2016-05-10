
public class Main {

	public static void main(String[] args) {
		System.out.println("+-------------------------------------+");
		System.out.println("|----------- TRUCO MINEIRO -----------|");
		System.out.println("+-------------------------------------+");
		System.out.println("|                                     |");
		System.out.println("|Lembre-se: Você pertence à equipe 2!!|");
		System.out.println("+-------------------------------------+");
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
