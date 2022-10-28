import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * 100
 * 10
 * 3
 * 0
 * 50 4
 * 30 5
 * 25 20
 * 4
 * 1
 * 
 */

public class App {
  private static Unit monster;
  private static Unit[] heroes;
  private static int striker;
  private static int buffStrength;
  private static int buffCharges;

  public static void main(String[] args) throws Exception {
    readInput();
  }

  private static void readInput() {
    Scanner scanner = new Scanner(System.in);
    // MH: 100
    // MA: 10
    monster = new Unit(scanner.nextInt(), scanner.nextInt());
    // N: 3
    heroes = new Unit[scanner.nextInt()];
    // S: 0
    striker = scanner.nextInt();

    // HH_0: 50, HA_0: 4
    // HH_1: 30, HA_1: 5
    // HH_2: 25, HA_2: 20
    for (int i = 0; i < heroes.length; i++) {
      String[] linha = scanner.nextLine().split(" ");
      heroes[i] = new Unit(Integer.parseInt(linha[0]), Integer.parseInt(linha[1]));
    }
    // B: 4
    buffStrength = scanner.nextInt();
    // K: 1
    buffCharges = scanner.nextInt();

    scanner.close();
  }
}
// for(Line line:heroLines)

// roundDamage = 29, 33
// //roundTank = 105
// //checar se tem resto
// int penultimoRound = 100/29 = 3;
// MH -= penultimoRound*roundDamage;

// closestHero = h[0];
// while(!failed) {
// closestHero.hp -= monster.