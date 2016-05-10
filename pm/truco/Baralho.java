package pm.truco;

import java.util.*;

public interface Baralho {
  public List<Carta> retirarCartas(int n);
  public Stack<Carta> getCartas();
  public String[] getNaipesValidos();
  public char[] getNumerosValidos();
}
