import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

import model.HeroQueue;
import model.Scenario;
import model.Unit;
import state.State;

public class App {
  private static ArrayList<Deque<Integer>> combinacoes = new ArrayList<>();

  public static void main(String[] args) throws Exception {

    ArrayList<Scenario> cenarios = readInput();

    boolean deuCerto = false;

    for (Scenario scenario : cenarios) {
      while (!scenario.isFinished())
        scenario.nextRound();

      if(scenario.getResult() == State.SUCCESS) {
        deuCerto = true;
        System.out.println(scenario.getResult());
        for (Integer position : scenario.getBuffedHeroes())
          System.out.print(position + " ");

        break;
      }
    }

    if(!deuCerto)
      System.out.println(State.FAILURE);

  }

  private static ArrayList<Scenario> readInput() throws Exception {
    Scanner scanner = new Scanner(System.in);
    Unit monster = new Unit(scanner.nextInt(), scanner.nextInt(), false);

    int numberOfHeroes = scanner.nextInt();
    int special = scanner.nextInt();

    HeroQueue heroes = new HeroQueue();
    for (int i = 0; i < numberOfHeroes; i++)
      heroes.enfileirar(new Unit(scanner.nextInt(), scanner.nextInt(), i == special));

    int buffStrength = scanner.nextInt();
    int buffCharges = scanner.nextInt();

    scanner.close();

    Scenario cenarioBase = new Scenario(monster, heroes, special);
    ArrayList<Scenario> cenarios = new ArrayList<>();

    gerarCombinacoes(numberOfHeroes, buffCharges);

    for (Deque<Integer> combinacao : combinacoes) {
      Scenario cenarioAux = cenarioBase.clone();

      for (Integer posicaoHeroi : combinacao)
        cenarioAux.applyBuff(posicaoHeroi, buffStrength);
      
      cenarios.add(cenarioAux);
    }

    return cenarios;
  }

  private static void gerarCombinacoes(int n, int r) {
    int[] array = new int[n];
    for (int i = 0; i < array.length; i++)
      array[i] = i;

    Deque<Integer> out = new ArrayDeque<>();
    findCombinations(array, out, r, 0, array.length);
  }

  private static void findCombinations(int[] A, Deque<Integer> out, int r, int i, int n) {
    if (out.size() == r) {
      ArrayDeque<Integer> aux = new ArrayDeque<>(out);
      combinacoes.add(aux);
      return;
    }

    for (int j = i; j < n; j++) {
      out.addLast(A[j]);
      findCombinations(A, out, r, j, n);

      out.pollLast();
    }
  }
}