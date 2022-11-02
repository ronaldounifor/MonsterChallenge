import java.util.ArrayList;
import java.util.Scanner;

import model.HeroQueue;
import model.Scenario;
import model.Unit;

public class App {
  public static void main(String[] args) throws Exception {

    ArrayList<Scenario> cenarios = readInput();
    int numeroCenario = 0;

    for (Scenario scenario : cenarios) {
      while (!scenario.isFinished())
        scenario.nextRound();
      
      System.out.println("Resultados do cenário '" + ++numeroCenario + "':");
      System.out.println(scenario.getResult());
      for (Integer position : scenario.getBuffedHeroes()) {
        System.out.print(position + " ");
      }
      System.out.println();System.out.println();
    }

  }

  private static ArrayList<Scenario> readInput() throws Exception {
    Scanner scanner = new Scanner(System.in);
    Unit monster = new Unit(scanner.nextInt(), scanner.nextInt(), false);

    int numeroOfHeroes = scanner.nextInt();
    int special = scanner.nextInt();

    HeroQueue heroes = new HeroQueue();
    for (int i = 0; i < numeroOfHeroes; i++)
      heroes.enfileirar(new Unit(scanner.nextInt(), scanner.nextInt(), i == special));

    int buffStrength = scanner.nextInt();
    int buffCharges = scanner.nextInt();

    scanner.close();

    Scenario cenarioBase = new Scenario(monster, heroes, special);
    ArrayList<Scenario> cenarios = new ArrayList<>();

    cenarios.add(cenarioBase);

    for (int i = 0; i < numeroOfHeroes; i++) {
      Scenario cenarioAux = cenarioBase.clone();
      cenarioAux.applyBuff(i, buffStrength);
      cenarios.add(cenarioAux);
    }

    return cenarios;
  }

}