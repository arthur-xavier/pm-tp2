package pm.truco.baralho;

import java.util.*;

public interface Baralho {
  public void embaralhar();
  public List<Carta> retirarCartas(int n);
  public Stack<Carta> getCartas();
  public String[] getNaipesValidos();
  public char[] getNumerosValidos();
}
