import java.util.Scanner;

import model.HeroQueue;
import model.Scenario;
import model.Unit;

import java.util.List;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) throws Exception {
    

    Scenario scenario = readInput();

    while(!scenario.isFinished()) {
      scenario.nextRound();
    }
    
    System.out.println(scenario.getResult());




    // // ArrayList<Scenario> scenarios = new ArrayList<>();
    // // scenarios.add(scenario);
    // // adicionar todos os possíveis scenarios com buffs

    // runScenario(scenario);

    // calculateTankValue();
    
    // while(currentTank <= special) {

    //   heroes[currentTank].setHealth(heroes[currentTank].getHealth() - monster.getAttack());

    //   if(heroes[currentTank].getHealth() <= 0)
    //     currentTank++;

    //   calculateRoundDamage();
    //   if(monster.getHealth() > roundDamage)
    //     monster.setHealth(monster.getHealth() - roundDamage)
    //   else if(isSpecialKill())
    //     System.out.print("success");
    
    
    // printAll();
  }

  //FIXME depois mudar para ArrayList<Scenario> no retorno
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

  // private static double roundsForKill() {
    
  // }

  // private static double roundsForWipe() {
  //   return Math.ceil((double)tankValue/monster.getAttack());
  // }

  // private static void calculateRoundDamage() {
  //   roundDamage = 0;
  //   for(int i = currentTank; i < heroes.length; i++)
  //     roundDamage += heroes[i].getAttack();
  // }

  // private static void isSpecialKill() {
  //   int damage = 0;
  //   for(int i = currentTank; i < !heroes[i-1].isSpecial(); i++)
  //     damage += heroes[i].getAttack();

  //   return monster.getHealth() < damage;
  // }
  
  // private static void calculateTankValue() {
  //   tankValue = heroes[0].getHealth();
    
  //   if(!heroes[0].isSpecial())
  //     for(int i = 1; !heroes[i-1].isSpecial(); i++)
  //       tankValue += heroes[i].getHealth();
  // }

  

  // private static void printAll() {
  //   System.out.println("Monstro HP: "+monster.getHealth());
  //   System.out.println("Monstro Atk: "+monster.getAttack());
  //   System.out.println("Heroi 1 HP: "+heroes[0].getHealth());
  //   System.out.println("Heroi 1 Atk: "+heroes[0].getAttack());
  //   System.out.println("Heroi 2 HP: "+heroes[1].getHealth());
  //   System.out.println("Heroi 2 Atk: "+heroes[1].getAttack());
  //   System.out.println("Heroi 3 HP: "+heroes[2].getHealth());
  //   System.out.println("Heroi 3 Atk: "+heroes[2].getAttack());
  //   System.out.println("Special: Hero "+(special+1));
  //   System.out.println("Buff Strength: "+buffStrength);
  //   System.out.println("Buff Charges: "+buffCharges);
  // }
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