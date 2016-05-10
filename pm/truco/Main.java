package pm.truco;

public class Main {

	public static void main(String[] args) {
		System.out.println("+-------------------------------------+");
		System.out.println("|----------- TRUCO MINEIRO -----------|");
		System.out.println("+-------------------------------------+");
		System.out.println("|                                     |");
		System.out.println("|Lembre-se: Você pertence à equipe 2!!|");
		System.out.println("+-------------------------------------+");

    TrucoBuilder builder = new TrucoBuilder();
    Truco truco = builder.criarTrucoDoisJogadores();
    truco.jogar();
	}
}
