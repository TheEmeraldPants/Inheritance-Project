import java.util.Scanner;
import java.util.ArrayList;
public class Main
{
public static void main(String[] args) {
        int money = 1000;
        Scanner scan = new Scanner(System.in);
        System.out.println("You are in a MicroCenter.");
        System.out.println("You need to make a new computer! You have $1000 to your name, and a dream.");
        System.out.println("------------------YOU HAVE: $" + money + "------------------");

        System.out.println("You are in the motherboard isle.");

}

public int choices(String component, Scanner s) {
        boolean validChoice = false;
        while (!validChoice) {
                System.out.println("Would you like to: ");
                System.out.println("0: Look at what is on the shelf.");
                System.out.println("1: Learn more about " + component + ".");
                System.out.println("2: Ask a MicroCenter employee for advice.");
                System.out.println("3: Check your wallet.");

                System.out.println("Type the corresponding number of each choice to act.");
                int choice = s.nextInt();
                if (choice > 3 || choice < 0) System.out.println("That is not a valid option.");
                
        }
        



        return -1;
}
}