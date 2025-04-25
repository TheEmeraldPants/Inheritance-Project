public class Main{
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

    Motherboard am4BudgetMotherboard = new Motherboard(60.00, "ASRock", false, 40, "AM4 motherboard with support for Ryzen 3000 and 5000 series", 12, 2, 5, "AMD AM4", "USB 3.2, HDMI, DisplayPort");
    Motherboard am5Tier1 = new Motherboard(150.00, "MSI", true, 70, "AM5 motherboard for Ryzen 7000 series with high-end VRMs", 12, 4, 5, "AMD AM5", "USB 4.0, Wi-Fi 6E, Bluetooth 5.2");
    Motherboard am5Tier2 = new Motherboard(200.00, "ASUS", true, 85, "AM5 motherboard with support for PCIe Gen 5 and DDR5", 12, 4, 5, "AMD AM5", "USB 3.2, HDMI, DisplayPort, Wi-Fi 6E");
    Motherboard am5Tier3 = new Motherboard(250.00, "Gigabyte", true, 95, "High-end AM5 motherboard with premium features like PCIe Gen 5 and advanced cooling", 12, 4, 5, "AMD AM5", "USB 3.2, DisplayPort, Wi-Fi 6E, Bluetooth 5.2");
    
    Motherboard intelTier1 = new Motherboard(100.00, "ASRock", false, 50, "Intel motherboard for 12th Gen with DDR4 support", 12, 4, 1700, "Intel", "USB 3.2, DisplayPort");
    Motherboard intelTier2 = new Motherboard(150.00, "MSI", true, 65, "Intel motherboard with support for 13th Gen and DDR5", 12, 4, 1700, "Intel", "USB 3.2, HDMI, DisplayPort, Wi-Fi 6");
    Motherboard intelTier3 = new Motherboard(200.00, "Gigabyte", true, 80, "Intel Z690 motherboard with PCIe Gen 5 and DDR5 support", 12, 4, 1700, "Intel", "USB 4.0, Wi-Fi 6, Bluetooth 5.2");
    Motherboard intelTier4 = new Motherboard(250.00, "ASUS", true, 95, "Premium Intel motherboard with advanced features for 12th/13th Gen", 12, 4, 1700, "Intel", "USB 3.2, DisplayPort, Wi-Fi 6E, Bluetooth 5.2");

    PSU msiMAGA550BN = new PSU(50.00, "MSI", false, 50, "MSI MAG A550BN is a reliable 550W PSU with great efficiency.", 550);
    PSU msiMAGA650BN = new PSU(60.00, "MSI", false, 60, "MSI MAG A650BN is a 650W PSU with great power efficiency and stability.", 650);
    PSU msiMPGA750GF = new PSU(120.00, "MSI", true, 120, "MSI MPG A750GF is a 750W PSU with 80+ Gold efficiency and modular cables.", 750);
    PSU msiMAGA750GL = new PSU(100.00, "MSI", false, 100, "MSI MAG A750GL is a 750W power supply with solid performance for gaming PCs.", 750);
    PSU corsairRM850x = new PSU(130.00, "Corsair", false, 130, "Corsair RM850x is an 850W PSU with high efficiency and fully modular design.", 850);

RAM budgetRAM = new RAM(50.00, "Corsair", false, 50, "Corsair 12GB DDR4 RAM for budget builds.", 4, 12, 2666, "DDR4");
RAM midRAM16GBDDR4 = new RAM(80.00, "Corsair", true, 80, "Corsair 16GB DDR4 RAM with RGB lighting.", 4, 16, 3200, "DDR4");
RAM midRAM16GBDDR5 = new RAM(120.00, "G.Skill", true, 75, "G.Skill 16GB DDR5 RAM with RGB.", 5, 16, 4800, "DDR5");
RAM highRAM32GBDDR5 = new RAM(240.00, "Corsair", true, 100, "Corsair 32GB DDR5 RAM with high speed for performance builds.", 5, 32, 6000, "DDR5");

Storage budgetSSD = new Storage(50.00, "Samsung", false, 10, "Samsung 512GB SSD for budget builds.", 512, 3500, "SSD");
Storage midSSD1TB = new Storage(90.00, "Western Digital", true, 15, "WD 1TB SSD with RGB lighting for mid-range builds.", 1024, 5000, "SSD");
Storage highSSD2TB = new Storage(180.00, "Crucial", true, 20, "Crucial 2TB SSD with high performance for high-end builds.", 2048, 5500, "SSD");
Storage budgetHDD2TB = new Storage(50.00, "Seagate", false, 25, "Seagate 2TB HDD for storage-heavy budget builds.", 2048, 150, "HDD");
Storage highHDD4TB = new Storage(120.00, "Western Digital", false, 35, "WD 4TB HDD for large storage needs in high-end builds.", 4096, 150, "HDD");

UPS budgetUPS = new UPS(80.00, "CyberPower", false, 25, "CyberPower 1000VA UPS for budget builds, provides basic power protection.", 1000);
UPS longLastingUPS = new UPS(250.00, "APC", false, 40, "APC Smart-UPS 1500VA, reliable and long-lasting for high-end systems.", 1500);








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
            System.out.println("What is the most intensive task you'll be doing on your computer?");
        System.out.println("1. Gaming");
        System.out.println("2. Video Editing");
        System.out.println("3. 3D Rendering");
        System.out.println("4. Programming");
        System.out.println("5. Office Work");

        int taskChoice = scan.nextInt();
        suggestPrebuilt(taskChoice, budgetPrebuilt, midrangeBuild, highEndBuild, ultraBuild, fourKBuild, insane4040Build);
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
                System.out.println("Suggested Prebuilt: General Use PC with inexpesive components.");
                break;
    }
}
}
