import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        readInput();
    }

    private static void readInput() {
        Scanner scanner = new Scanner(System.in);
 
        while (scanner.hasNextLine()) {
            List<String> tokens = new ArrayList<>();
            Scanner lineScanner = new Scanner(scanner.nextLine());
 
            while (lineScanner.hasNext()) {
                tokens.add(lineScanner.next());
            }
 
            lineScanner.close();
            System.out.println(tokens);
        }
 
        scanner.close();
    }
}
// MH: 100
// MA: 10
// N: 3
// S: 0
// HH_0: 50, HA_0: 4
// HH_1: 30, HA_1: 5
// HH_2: 25, HA_2: 20
// B: 4
// K: 1

// Unit monster = new Unit(MH, MA);
// Unit[] heros = new Unit[N];
// int striker = S;
// for(Line line:heroLines)


// roundDamage = 29, 33
// //roundTank = 105
// //checar se tem resto
// int penultimoRound = 100/29 = 3;
// MH -= penultimoRound*roundDamage;


// closestHero = h[0];
// while(!failed) {
// 	closestHero.hp -= monster.