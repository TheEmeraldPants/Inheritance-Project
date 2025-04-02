import java.util.Scanner;
import java.util.ArrayList;
public class Main
{
public static void main(String[] args) {
//         //You are in a computer store
// The employee asks you if you would like help building a computer run Ask loop to either custom or prebuilt computer
// If no, then ask for a case and then the motherboard
// Proceed with all other components that are compatible with the motherboard
// Suggest a psu and peripherals sum total power draw to find psu and then run peripherals loop
// Quote final price sum all prices

// If yes then ask what they mainly will use it for

        int cost = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("You are in a MicroCenter.");
        System.out.println("You need to make a new computer!");

        System.out.println("Would you like help building a computer? (yes/no)");
        String help = scan.nextLine(catch (Exception e) {
            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            help = scan.nextLine();
        });

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