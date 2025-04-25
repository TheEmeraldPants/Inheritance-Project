import java.util.Scanner;

public class CustomPCBuilder {
    Scanner scanner = new Scanner(System.in);
    double totalCost = 0;
    CPU selectedCPU = null;
    Motherboard selectedMotherboard = null;
    GPU selectedGPU = null;
    RAM selectedRAM = null;
    Storage selectedStorage = null;
    Case selectedCase = null;
    PSU selectedPSU = null;
    UPS selectedUPS = null;

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

GPU rtx4060 = new GPU(350.00, "NVIDIA", true, 150, "NVIDIA RTX 4060 with 8GB VRAM, great for 1080p gaming.", 8, 3584, 1785, "NVIDIA");
GPU rtx4070 = new GPU(550.00, "NVIDIA", true, 200, "NVIDIA RTX 4070 with 12GB VRAM, perfect for 1440p gaming and ray tracing.", 12, 5888, 2100, "NVIDIA");
GPU rtx4090 = new GPU(1500.00, "NVIDIA", true, 350, "NVIDIA RTX 4090 with 24GB VRAM, for 4K gaming and heavy workloads.", 24, 16384, 2520, "NVIDIA");
GPU amdRX6600 = new GPU(250.00, "AMD", false, 130, "AMD RX 6600 with 8GB VRAM, great for budget gaming.", 8, 1792, 2044, "AMD");
GPU amdRX6700XT = new GPU(450.00, "AMD", true, 150, "AMD RX 6700XT with 12GB VRAM, excellent for 1440p gaming.", 12, 2560, 2424, "AMD");
GPU amdRX6900XT = new GPU(1000.00, "AMD", true, 250, "AMD RX 6900XT with 16GB VRAM, for 4K gaming and demanding applications.", 16, 5120, 2250, "AMD");
GPU intelARC750 = new GPU(400.00, "Intel", false, 180, "Intel ARC A750 with 8GB VRAM, a solid choice for mainstream gaming.", 8, 4096, 2400, "Intel");
        

UPS budgetUPS = new UPS(80.00, "CyberPower", false, 25, "CyberPower 1000VA UPS for budget builds, provides basic power protection.", 1000);
UPS longLastingUPS = new UPS(250.00, "APC", false, 40, "APC Smart-UPS 1500VA, reliable and long-lasting for high-end systems.", 1500);





    public static void main(String[] args) {
        new CustomPCBuilder().buildCustomPC();
    }

    public void buildCustomPC() {
        boolean building = true;

        while (building) {
            System.out.println("\n--- Custom PC Builder ---");
            System.out.println("1. Start Building");
            System.out.println("2. Reset Build");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();

            if (choice == 1) {
                int step = 0;
                while (step < 7) {
                    if (step == 0) {
                        if (selectCPU()) step++;
                        else step--;
                    } else if (step == 1) {
                        if (selectMotherboard()) step++;
                        else step--;
                    } else if (step == 2) {
                        if (selectGPU()) step++;
                        else step--;
                    } else if (step == 3) {
                        if (selectRAM()) step++;
                        else step--;
                    } else if (step == 4) {
                        if (selectStorage()) step++;
                        else step--;
                    } else if (step == 5) {
                        if (selectCase()) step++;
                        else step--;
                    } else if (step == 6) {
                        if (selectPSU()) step++;
                        else step--;
                    }
                }
                
                System.out.println("\nBuild Complete! Total cost: $" + totalCost);
                System.out.println( "Do you want to select a UPS?" );
                System.out.println( "1. Yes" );
                System.out.println( "2. No" );
                System.out.println( "3. Exit" );
                int upsChoice = scanner.nextInt();
                if (upsChoice == 1) {
                    selectUPS();
                } else if (upsChoice == 2) {
                    System.out.println("No UPS selected.");
                } else if (upsChoice == 3) {
                    System.out.println("Exiting...");
                    return;
                } else {
                    System.out.println("Invalid choice. Exiting...");
                    return;
                }
                
                System.out.println("Do you want to go back and change a component? (1 = Yes, 0 = No)");
                if (scanner.nextInt() == 1) {
                    buildCustomPC(); // restart build
                } else {
                    return;
                }
            } else if (choice == 2) {
                resetBuild();
            } else if (choice == 3) {
                building = false;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
    }

    public void resetBuild() {
        totalCost = 0;
        selectedCPU = null;
        selectedMotherboard = null;
        selectedGPU = null;
        selectedRAM = null;
        selectedStorage = null;
        selectedCase = null;
        selectedPSU = null;
        selectedUPS = null;
        System.out.println("Build reset.\n");
    }

    public void selectUPS() {
        System.out.println("Would you like to include a UPS?");
        System.out.println("1. Yes (Cost: $150)");
        System.out.println("2. No (No cost added)");
        System.out.print("Enter your choice (1 for Yes, 2 for No): ");
        int choice = scanner.nextInt();
        
        if (choice == 1) {
            selectedUPS = new UPS(150.00, "CyberPower", true, 20, "CyberPower UPS for gaming PCs", 900);
            totalCost += selectedUPS.getPrice();
            System.out.println("You selected a UPS: " + selectedUPS.getDescription());
        } else if (choice == 2) {
            selectedUPS = null;
            System.out.println("No UPS selected.");
        } else {
            System.out.println("Invalid choice. Please select again.");
            selectUPS();
            return;
        }
    
        System.out.println("Total cost updated: $" + totalCost);
    }
    

    public Boolean selectStorage() {
        boolean validChoice = false;
        while (!validChoice) {
            System.out.println("Select a storage option:");
            System.out.println("1. Samsung 512GB SSD - $50.00");
            System.out.println("2. WD 1TB SSD with RGB - $90.00");
            System.out.println("3. Crucial 2TB SSD - $180.00");
            System.out.println("4. Seagate 2TB HDD - $50.00");
            System.out.println("5. WD 4TB HDD - $120.00");
            System.out.print("Enter the number of your choice: ");
            int choice = scanner.nextInt();
    
            switch (choice) {
                case 1:
                    selectedStorage = budgetSSD;
                    validChoice = true;
                    break;
                case 2:
                    selectedStorage = midSSD1TB;
                    validChoice = true;
                    break;
                case 3:
                    selectedStorage = highSSD2TB;
                    validChoice = true;
                    break;
                case 4:
                    selectedStorage = budgetHDD2TB;
                    validChoice = true;
                    break;
                case 5:
                    selectedStorage = highHDD4TB;
                    validChoice = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    
        totalCost += selectedStorage.getPrice();
        System.out.println("You selected: " + selectedStorage.getDescription());
        System.out.println("Total cost updated: $" + totalCost);
        return true;
    }
    public Boolean selectCase() {
        System.out.println("Select a case:");
        System.out.println("1. Sama Budget Case - $70.00");
        System.out.println("2. Fractal Design Clean Case - $120.00");
        System.out.println("3. Corsair Premium RGB Case - $180.00");
        System.out.print("Enter the number of your choice: ");
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                selectedCase = case1;
                break;
            case 2:
                selectedCase = case2;
                break;
            case 3:
                selectedCase = case3;
                break;
            default:
                System.out.println("Invalid choice. Please select again.");
                selectCase();
                
        }
        
        totalCost += selectedCase.getPrice();
        System.out.println("You selected: " + selectedCase.getDescription());
        System.out.println("Total cost updated: $" + totalCost);
        return true;
    }
        
    public boolean selectCPU() {
        System.out.println("\nSelect a CPU (or enter -1 to go back):");
        System.out.println("0: Intel Core i3-12100 - $119.99");
        System.out.println("1: Intel Core i5-13600K - $250.00");
        System.out.println("2: Intel Core i7-13700K - $400.00");
        System.out.println("3: Intel Core i9-13900K - $650.00");
        System.out.println("4: AMD Ryzen 3/5 Budget CPU - $150.00");
        System.out.println("5: AMD Ryzen 5 Mid-Range AM4 - $250.00");
        System.out.println("6: AMD Ryzen 7 Mid-Range AM5 - $350.00");
        System.out.println("7: AMD Ryzen 7 High-End AM5 - $550.00");
        System.out.println("8: AMD Ryzen 9 Ultra High-End AM5 - $750.00");
        System.out.print("Choose index: ");
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 0:
                selectedCPU = intelCorei3_12100;
                break;
            case 1:
                selectedCPU = i5;
                break;
            case 2:
                selectedCPU = i7;
                break;
            case 3:
                selectedCPU = i9;
                break;
            case 4:
                selectedCPU = budgetCPU;
                break;
            case 5:
                selectedCPU = midRangeAM4;
                break;
            case 6:
                selectedCPU = midRangeAM5;
                break;
            case 7:
                selectedCPU = highEndAM5;
                break;
            case 8:
                selectedCPU = ultraAM5;
                break;
            case -1:
                return false;
            default:
                System.out.println("Invalid choice. Please select again.");
                return selectCPU(); // retry if invalid
        }
    
        totalCost += selectedCPU.getPrice();
        System.out.println("Selected CPU: " + selectedCPU.getDescription());
        System.out.println("Current total cost: $" + totalCost);
        return true;
    }
    

    public boolean selectMotherboard() {
        System.out.println("\nSelect a Motherboard (or enter -1 to go back):");
        System.out.println("0: AM4 Budget Motherboard - $60.00");
        System.out.println("1: AM5 Tier 1 Motherboard - $150.00");
        System.out.println("2: AM5 Tier 2 Motherboard - $200.00");
        System.out.println("3: AM5 Tier 3 Motherboard - $250.00");
        System.out.println("4: Intel Tier 1 Motherboard - $100.00");
        System.out.println("5: Intel Tier 2 Motherboard - $150.00");
        System.out.println("6: Intel Tier 3 Motherboard - $200.00");
        System.out.println("7: Intel Tier 4 Motherboard - $250.00");
        System.out.print("Choose index: ");
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 0:
                selectedMotherboard = am4BudgetMotherboard;
                break;
            case 1:
                selectedMotherboard = am5Tier1;
                break;
            case 2:
                selectedMotherboard = am5Tier2;
                break;
            case 3:
                selectedMotherboard = am5Tier3;
                break;
            case 4:
                selectedMotherboard = intelTier1;
                break;
            case 5:
                selectedMotherboard = intelTier2;
                break;
            case 6:
                selectedMotherboard = intelTier3;
                break;
            case 7:
                selectedMotherboard = intelTier4;
                break;
            case -1:
                return false;
            default:
                System.out.println("Invalid choice. Please select again.");
                return selectMotherboard(); // retry if invalid
        }
    
        totalCost += selectedMotherboard.getPrice();
        System.out.println("Selected Motherboard: " + selectedMotherboard.getDescription());
        System.out.println("Current total cost: $" + totalCost);
        return true;
    }
    

    public boolean selectGPU() {
        // Example GPUs: Add real GPU options with prices and descriptions
System.out.println("\nSelect a GPU (or enter -1 to go back):");
System.out.println("0: Nvidia RTX 4060 - $350.00");
System.out.println("1: Nvidia RTX 4070 - $550.00");
System.out.println("2: Nvidia RTX 4090 - $1500.00");
System.out.println("3: AMD Radeon RX 6600 - $250.00");
System.out.println("4: AMD Radeon RX 6700 XT - $450.00");
System.out.println("5: AMD Radeon RX 6900 XT - $1000.00");
System.out.println("6: Intel ARC A750 - $400.00");

        System.out.print("Choose index: ");
        int choice = scanner.nextInt();
        if (choice == -1) return false;

        if (choice == 0) {
            selectedGPU = rtx4060; // NVIDIA RTX 4060
        } else if (choice == 1) {
            selectedGPU = rtx4070; // NVIDIA RTX 4070
        } else if (choice == 2) {
            selectedGPU = rtx4090; // NVIDIA RTX 4090
        } else if (choice == 3) {
            selectedGPU = amdRX6600; // AMD RX 6600
        } else if (choice == 4) {
            selectedGPU = amdRX6700XT; // AMD RX 6700 XT
        } else if (choice == 5) {
            selectedGPU = amdRX6900XT; // AMD RX 6900 XT
        } else if (choice == 6) {
            selectedGPU = intelARC750; // Intel ARC A750
        }
        
        totalCost += selectedGPU.getPrice();
        System.out.println("Selected GPU: " + selectedGPU.getDescription());
        System.out.println("Current total cost: $" + totalCost);
        return true;
    }

    public boolean selectRAM() {
        System.out.println("\nSelect RAM (or enter -1 to go back):");
        System.out.println("0: Corsair 12GB DDR4 - $50.00");
        System.out.println("1: Corsair 16GB DDR4 RGB - $80.00");
        System.out.println("2: G.Skill 16GB DDR5 RGB - $120.00");
        System.out.println("3: Corsair 32GB DDR5 - $240.00");
        System.out.print("Choose index: ");
        int choice = scanner.nextInt();
    
        switch (choice) {
            case 0:
                selectedRAM = budgetRAM;
                break;
            case 1:
                selectedRAM = midRAM16GBDDR4;
                break;
            case 2:
                selectedRAM = midRAM16GBDDR5;
                break;
            case 3:
                selectedRAM = highRAM32GBDDR5;
                break;
            case -1:
                return false;
            default:
                System.out.println("Invalid choice. Please select again.");
                return selectRAM(); // retry if invalid
        }
    
        totalCost += selectedRAM.getPrice();
        System.out.println("Selected RAM: " + selectedRAM.getDescription());
        System.out.println("Current total cost: $" + totalCost);
        return true;
    }
    
    

    public boolean selectPSU() {
        System.out.println("\nSelect a PSU (or enter -1 to go back):");
        System.out.println("0: MSI MAG A550BN - $50.00");
        System.out.println("1: MSI MAG A650BN - $60.00");
        System.out.println("2: MSI MPG A750GF - $120.00");
        System.out.println("3: MSI MAG A750GL - $100.00");
        System.out.println("4: Corsair RM850x - $130.00");
        System.out.print("Choose index: ");
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 0:
                selectedPSU = msiMAGA550BN;
                break;
            case 1:
                selectedPSU = msiMAGA650BN;
                break;
            case 2:
                selectedPSU = msiMPGA750GF;
                break;
            case 3:
                selectedPSU = msiMAGA750GL;
                break;
            case 4:
                selectedPSU = corsairRM850x;
                break;
            case -1:
                return false;
            default:
                System.out.println("Invalid choice. Please select again.");
                return selectPSU(); // retry if invalid
        }
    
        totalCost += selectedPSU.getPrice();
        System.out.println("Selected PSU: " + selectedPSU.getDescription());
        System.out.println("Current total cost: $" + totalCost);
        return true;
    }
    
    
    

    // Add Storage and UPS methods (if necessary)
}
