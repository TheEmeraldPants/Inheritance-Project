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
// Gaming – High-performance gaming, VR gaming, or esports.

// Video Editing – 4K/8K video editing, rendering, and effects processing.

// 3D Rendering & Animation – Blender, Maya, Cinema 4D, or CAD modeling.

// Machine Learning & AI – Training deep learning models, AI research.

// Software Development – Compiling large projects, running VMs, game development.

// Graphic Design – Photoshop, Illustrator, large-scale image processing.

// Music Production – DAWs like FL Studio, Ableton Live, large track processing.

// Streaming & Content Creation – Live streaming while gaming, video production.

// Engineering & Simulation – MATLAB, AutoCAD, SolidWorks, physics simulations.
// Is there is an invalid input, keep asking until a valid input is given using while loop
// ask if theyd like to exit or go back a step if its invalid input

        int cost = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("You are in a MicroCenter.");
        System.out.println("You need to make a new computer!");

        System.out.println("Would you like help building a computer? (yes/no)");
        String help = scan.nextLine().toLowerCase();
        while (!help.equals("yes") && !help.equals("no")) {
            System.out.println("Please answer with 'yes' or 'no'.");
            help = scan.nextLine().toLowerCase();
        }
        if (help.equals("yes")) {
            System.out.println("Great! What will be the most intensive use of your computer?");
                System.out.println("1. Gaming");
                System.out.println("2. Video Editing");
                System.out.println("3. 3D Rendering & Animation");
                System.out.println("4. Machine Learning & AI");
                System.out.println("5. Software Development");
                System.out.println("6. Graphic Design");
                System.out.println("7. Music Production");
                System.out.println("8. Streaming & Content Creation");
                System.out.println("9. Engineering & Simulation");
                System.out.println("10. General Use");

            int use = scan.nextInt();
            while (use < 1 || use > 10) {
                System.out.println("Please choose a valid option (1-10).");
                use = scan.nextInt();
            }

        String[] uses = {"Gaming", "Video Editing", "3D Rendering & Animation", "Machine Learning & AI", "Software Development", "Graphic Design", "Music Production", "Streaming & Content Creation", "Engineering & Simulation", "General Use"};
        System.out.println("You chose: " + uses[use - 1] + ".");
        System.out.println("The employee will suggest a prebuilt computer for you.");
        try {
            Thread.sleep(2000); // Simulate a delay for the employee to suggest a prebuilt computer
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("An error occurred while pausing execution.");
        }
        System.out.println("The employee suggests a prebuilt computer with the following specs:");
        

    }
  
        
        
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

//method to suggest prebilt based on use case
public void suggestPrebuilt(int use) {
    // Suggest a prebuilt computer based on the use case
        switch (use) {
                case 1:
                System.out.println("Suggested Prebuilt: Gaming PC with high-end GPU and CPU.");
                break;
                case 2:
                System.out.println("Suggested Prebuilt: Video Editing PC with powerful CPU and GPU.");
                break;
                case 3:
                System.out.println("Suggested Prebuilt: 3D Rendering PC with high-performance CPU and GPU.");
                break;
                case 4:
                System.out.println("Suggested Prebuilt: Machine Learning PC with multiple GPUs.");
                break;
                case 5:
                System.out.println("Suggested Prebuilt: Software Development PC with a balanced CPU and RAM.");
                break;
                case 6:
                System.out.println("Suggested Prebuilt: Graphic Design PC with high-resolution monitor and GPU.");
                break;
                case 7:
                System.out.println("Suggested Prebuilt: Music Production PC with low-latency audio interface.");
                break;
                case 8:
                System.out.println("Suggested Prebuilt: Streaming PC with dual GPUs for gaming and streaming.");
                break;
                case 9:
                System.out.println("Suggested Prebuilt: Engineering PC with high-performance CPU and RAM.");
                break;
                case 10:
                System.out.println("Suggested Prebuilt: General Use PC with inexpesive components.");
                break;
    }
}
}