import java.util.Scanner;

import model.HeroQueue;
import model.Scenario;
import model.Unit;

public class App {
  public static void main(String[] args) throws Exception {

    Scenario cenarioBase = readInput();

    Scenario cenarioAtual = cenarioBase.clone();

    //cenario com zero cargas
    //cenario com uma carga
      //round 0
        //buffar heroi 0
        //buffar heroi 1
        //...
        //buffar heroi n (quantos estiverem vivos nesse round)
      //round 1
        //mesmo
      //...
      //round n (até finalizar)
        //mesmo
    //cenario com duas cargas
      //mesmo
    //...
    //cenario com todas as cargas
      //mesmo

    while (!cenarioAtual.isFinished())
      cenarioAtual.nextRound();

    System.out.println(cenarioAtual.getResult());

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