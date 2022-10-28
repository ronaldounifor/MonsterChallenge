import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * 100 10 3 0 50 4 30 5 25 20 4 1
 * 
 */

public class App {
  private static Unit monster;
  private static Unit[] heroes;
  private static int special;
  private static int buffStrength;
  private static int buffCharges;

  private static int tankValue;
  private static int roundDamage;

  private static int currentTank = 0;
  

  public static void main(String[] args) throws Exception {
    readInput();

    calculateTankValue();
    
    while(currentTank <= special) {

      heroes[currentTank].setHealth(heroes[currentTank].getHealth() - monster.getAttack());

      if(heroes[currentTank].getHealth() <= 0)
        currentTank++;

      calculateRoundDamage();
      if(monster.getHealth() > roundDamage)
        monster.setHealth(monster.getHealth() - roundDamage)
      else if(isSpecialKill())
        System.out.print("success");
    }
    
    // printAll();
  }

  private static double roundsForKill() {
    
  }

  private static double roundsForWipe() {
    return Math.ceil((double)tankValue/monster.getAttack());
  }

  private static void calculateRoundDamage() {
    roundDamage = 0;
    for(int i = currentTank; i < heroes.length; i++)
      roundDamage += heroes[i].getAttack();
  }

  private static void isSpecialKill() {
    int damage = 0;
    for(int i = currentTank; i < !heroes[i-1].isSpecial(); i++)
      damage += heroes[i].getAttack();

    return monster.getHealth() < damage;
  }
  
  private static void calculateTankValue() {
    tankValue = heroes[0].getHealth();
    
    if(!heroes[0].isSpecial())
      for(int i = 1; !heroes[i-1].isSpecial(); i++)
        tankValue += heroes[i].getHealth();
  }

  private static void readInput() {
    Scanner scanner = new Scanner(System.in);
    monster = new Unit(scanner.nextInt(), scanner.nextInt());
    
    heroes = new Unit[scanner.nextInt()];
    special = scanner.nextInt();

    for (int i = 0; i < heroes.length; i++) 
      heroes[i] = new Unit(scanner.nextInt(), scanner.nextInt());
    
    buffStrength = scanner.nextInt();
    buffCharges = scanner.nextInt();

    scanner.close();
  }

  private static void printAll() {
    System.out.println("Monstro HP: "+monster.getHealth());
    System.out.println("Monstro Atk: "+monster.getAttack());
    System.out.println("Heroi 1 HP: "+heroes[0].getHealth());
    System.out.println("Heroi 1 Atk: "+heroes[0].getAttack());
    System.out.println("Heroi 2 HP: "+heroes[1].getHealth());
    System.out.println("Heroi 2 Atk: "+heroes[1].getAttack());
    System.out.println("Heroi 3 HP: "+heroes[2].getHealth());
    System.out.println("Heroi 3 Atk: "+heroes[2].getAttack());
    System.out.println("Special: Hero "+(special+1));
    System.out.println("Buff Strength: "+buffStrength);
    System.out.println("Buff Charges: "+buffCharges);
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