import java.util.Scanner;

import model.HeroQueue;
import model.Scenario;
import model.Unit;

import java.util.ArrayList;

public class App {
  public static void main(String[] args) throws Exception {

    // ArrayList<Scenario> scenarios = readInput();

    Scenario scenario = readInput();

    // for (Scenario scenario : scenarios) {

      while (!scenario.isFinished())
        scenario.nextRound();

      System.out.println(scenario.getResult());
    // }

  }

  private static Scenario readInput() {
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

    return new Scenario(monster, heroes, special, buffStrength, buffCharges);
  }

}