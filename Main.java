import java.util.*;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
    int totalCost = 0;
    CPU selectedCPU = null;
    Motherboard selectedMotherboard = null;
    GPU selectedGPU = null;
    RAM selectedRAM = null;
    Storage selectedStorage = null;
    Case selectedCase = null;
    PSU selectedPSU = null;
    UPS selectedUPS = null;
    Monitor selectedMonitor = null;
    MousePad selectedMousePad = null;
    Mouse selectedMouse = null;
    Headset selectedHeadset = null;
    Keyboard selectedKeyboard = null;


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
        while (!help.equals("yes") && !help.equals("no") && !help.equals("y") && !help.equals("yeah") && !help.equals("sure") && !help.equals("n") && !help.equals("nah") && !help.equals("no thanks")) {
            System.out.println("Please answer with 'yes' or 'no'.");
            help = scan.nextLine().toLowerCase();
        }
        if (help.equals("yes") || help.equals("y") || help.equals("yeah") || help.equals("sure")) {
            System.out.println("What is the most intensive task you'll be doing on your computer?");
            System.out.println("1. Gaming");
            System.out.println("2. Video Editing");
            System.out.println("3. 3D Rendering");
            System.out.println("4. Programming");
            System.out.println("5. Office Work");
            int taskChoice = scan.nextInt();
            suggestPrebuilt(taskChoice, budgetPrebuilt, midrangeBuild, highEndBuild, ultraBuild, fourKBuild, insane4040Build);

            
        
    
        }
    else {
        new CustomPCBuilder().buildCustomPC();
        }

        System.out.println("Would you like to add peripherals? (yes/no)");
        String addPeripherals = scan.next().toLowerCase();
        while (!addPeripherals.equals("yes") && !addPeripherals.equals("no") && !addPeripherals.equals("y") && !addPeripherals.equals("n") && !addPeripherals.equals("sure") && !addPeripherals.equals("nah") && !addPeripherals.equals("no thanks")) {
            System.out.println("Please answer with 'yes' or 'no'.");
            addPeripherals = scan.next().toLowerCase();
        }
        if (addPeripherals.equals("yes") || addPeripherals.equals("y") || addPeripherals.equals("sure")) {
            System.out.println("Would you like to get suggestions for peripherals? (yes/no)");
            String getSuggestions = scan.next().toLowerCase();
            while (!getSuggestions.equals("yes") && !getSuggestions.equals("no") && !getSuggestions.equals("y") && !getSuggestions.equals("n") && !getSuggestions.equals("sure") && !getSuggestions.equals("nah") && !getSuggestions.equals("no thanks")) {
                System.out.println("Please answer with 'yes' or 'no'.");
                getSuggestions = scan.next().toLowerCase();
            }
            if (getSuggestions.equals("yes") || getSuggestions.equals("y") || getSuggestions.equals("sure")) {
               new SelectingPeripherals().suggestPeripherals();
            } else {
                //add peripherals dumbass
            }
        }
           
    }

    public static void suggestPrebuilt(int taskChoice, Prebuilt... builds) {
        switch (taskChoice) {
            case 1: // Gaming
                System.out.println("Recommended Prebuilt for Gaming: " + builds[3].toString());  // ultraBuild for 1440p
                break;

            case 2: // Video Editing
                System.out.println("Recommended Prebuilt for Video Editing: " + builds[4].toString()); // fourKBuild for better editing/rendering
                break;

            case 3: // 3D Rendering
                System.out.println("Recommended Prebuilt for 3D Rendering: " + builds[5].toString()); // insane4040Build for 3D rendering and heavy workloads
                break;

            case 4: // Programming
                System.out.println("Recommended Prebuilt for Programming: " + builds[0].toString());  // budgetPrebuilt for general coding tasks
                break;

            case 5: // Office Work
                System.out.println("Recommended Prebuilt for Office Work: " + builds[0].toString());  // budgetPrebuilt for office tasks
                break;

            default:
                System.out.println("Invalid choice. Please choose a valid option.");
        }
    }        

  
        
        




//method to suggest prebuilt based on use case
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
                System.out.println("Suggested Prebuilt: General Use PC with inexpensive components.");
                break;
    }
}

}