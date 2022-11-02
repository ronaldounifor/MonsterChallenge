import java.util.Scanner;

public class Scenario implements Cloneable {
    private static Unit monster;
    private static Unit[] heroes;
    private static int special;
    private static int buffStrength;
    private static int buffCharges;
  
    private static int tankValue;
    private static int roundDamage;
  
    private static int currentTank = 0;

    public Scenario() {
        readInput();
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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        
        return super.clone();
    }
    
}
