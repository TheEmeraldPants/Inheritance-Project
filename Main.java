import java.util.Scanner;
public class Main
{
public static void main(String[] args) {

    Prebuilt budgetPrebuilt = new Prebuilt(
            "Budget Prebuilt",
            570.0, // total estimated price
            "Mixed Brands",
            true, // has RGB (case, maybe GPU)
            297,  // estimated total power draw (CPU + GPU + misc)
            "A solid entry-level gaming PC featuring the Ryzen 5 5500 and RX 6600. Ideal for 1080p gaming. Will easily handle all productivity tasks.",
            550   // PSU wattage
        );
        Prebuilt midrangeBuild = new Prebuilt(
            "$750 Build Guide",
            750.0,
            "Mixed Brands",
            true,
            360,  // Estimated total power (CPU + GPU + others)
            "Improved 1080p gaming build with Ryzen 5 5500 and RX 7600 XT 16GB. Ideal for higher FPS and better graphics settings.",
            650   // Recommended PSU
        );
         Prebuilt highEndBuild = new Prebuilt(
            "$1000 Build Guide",
            1000.0,
            "Mixed Brands (AM5 Platform)",
            true,
            430,  // Estimate with Ryzen 5 7600(X) and RX 7700 XT
            "1440p gaming PC with Ryzen 5 7600(X) and RX 7700 XT. Ideal for Ultra settings and futureproofing.",
            750   // Recommended PSU wattage
        );
        Prebuilt ultraBuild = new Prebuilt(
            "$1500 Build Guide",
            1500.0,
            "AM5 Platform - Ryzen 7 7800X3D Build",
            true,
            500,  // Approximate combined draw with RX 7900 GRE + 7800X3D under load
            "High-end 1440p Ultra gaming PC with Ryzen 7 7800X3D and RX 7900 GRE. Excellent future-proof build.",
            750   // Recommended PSU wattage
        );
        Prebuilt fourKBuild = new Prebuilt(
            "$2000 Build Guide",
            2000.0,
            "AM5 Platform - Ryzen 7 7800X3D + RX 7900 XTX",
            true,
            550,  // Higher TDP from XTX + 7800X3D
            "High-end 1440p/4K gaming PC with Ryzen 7 7800X3D and RX 7900 XTX. Excellent value and future-proofing with 2TB fast SSD.",
            850   // Recommended PSU wattage for this combo
        );
        Prebuilt insane4040Build = new Prebuilt(
            "Ultimate RTX 4090 Build",
            2700.0,
            "AM5 Platform - Ryzen 7 7800X3D + RTX 4090",
            true,
            650,  // 7800X3D (~120W) + RTX 4090 (~450W+) + headroom
            "Top-tier 4K and creator build with RTX 4090 and Ryzen 7 7800X3D. Ideal for extreme gaming, streaming, and AI workloads.",
            1000  // Recommended PSU wattage for RTX 4090 + overhead
        );

    CPU intelCorei3_12100 = new CPU(119.99, "Intel", false, 58, "Intel Core i3-12100 with integrated Intel UHD Graphics 730", "Intel Core i3", 4, false,true);
    CPU i5 = new CPU(250.0, "Intel", false, 125, "Intel Core i5 13th Gen", "i5-13600K", 10, true,false);
    CPU i7 = new CPU(400.0, "Intel", false, 125, "Intel Core i7 13th Gen", "i7-13700K", 12, true,false);
    CPU i9 = new CPU(650.0, "Intel", false, 125, "Intel Core i9 13th Gen", "i9-13900K", 24, true,false);
    
    Case case1 = new Case (70.0, "Sama", true, 15, "Affordable RGB case for budget builds", "Mid Tower", "400mm x 200mm x 450mm", "2 x USB 2.0, 1 x USB 3.0 / Audio In & Out (HD) ", 3);
    Case case2 = new Case(120.0, "Fractal Design", false, 20, "Minimalistic clean design case with ample airflow", "ATX Tower", "500mm x 220mm x 460mm", "2x USB 3.0, USB Type-C (10 Gbps), Audio, RGB controller ", 3);
    Case case3 = new Case(180.0, "Corsair", true, 25, "Premium case with full RGB and great airflow", "Full Tower", "550mm x 250mm x 550mm", "\t(2x) USB 3.2 Gen 2 Type C, (4x) USB 3.2 Gen 1 Type A, (1x) Audio in/out", 4);
    
    CPU budgetCPU = new CPU(150, "AMD", false, 65, "A budget AMD CPU, Ryzen 3 or Ryzen 5, for entry-level gaming and multitasking.", "AM4", 4, false,true);
    CPU midRangeAM4 = new CPU(250, "AMD", false, 95, "An AMD Ryzen 5 CPU, great for gaming and productivity on the AM4 platform.", "AM4", 6, true,false);
    CPU midRangeAM5 = new CPU(350, "AMD", true, 105, "A Ryzen 7 processor for serious gaming and multi-threaded workloads on the AM5 platform.", "AM5", 8, true,false);
    CPU highEndAM5 = new CPU(550, "AMD", true, 125, "A high-end Ryzen 7 processor for 4K gaming and heavy workloads.", "AM5", 12, true,false);
    CPU ultraAM5 = new CPU(750, "AMD", true, 140, "An ultra-high-end Ryzen 9 processor for extreme gaming and productivity.", "AM5", 16, true,false);

    



    //You are in a computer store
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
