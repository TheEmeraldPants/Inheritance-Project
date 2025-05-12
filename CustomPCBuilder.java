import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// Base class for all PC components (aligned with user's preference)
abstract class Component {
    protected double price;
    protected String brand;
    protected boolean hasRGB;
    protected int powerConsumption; // Estimated power consumption in Watts (for load calculation, not component self-draw necessarily)
    protected String name; // A short name for the component
    protected String description;

    public Component(double price, String brand, boolean hasRGB, int powerConsumption, String name, String description) {
        this.price = price;
        this.brand = brand;
        this.hasRGB = hasRGB;
        this.powerConsumption = powerConsumption;
        this.name = name;
        this.description = description;
    }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public boolean getHasRGB() { return hasRGB; } // Changed from hasRgb() to getHasRGB for consistency with setters
    public void setHasRGB(boolean hasRGB) { this.hasRGB = hasRGB; }

    public int getPowerConsumption() { return powerConsumption; }
    public void setPowerConsumption(int powerConsumption) { this.powerConsumption = powerConsumption; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return name + " by " + brand + (hasRGB ? " (RGB)" : "") + " - $" + String.format("%.2f", price) + ". " + description;
    }
}

class CPU extends Component {
    private String modelName;
    private int coreCount;
    private boolean hasIntegratedGraphics;
    private String socketType; // e.g., "LGA1700", "AM4", "AM5"

    public CPU(double price, String brand, boolean hasRGB, int powerConsumption, String name, String description, String modelName, int coreCount, boolean hasIntegratedGraphics, String socketType) {
        super(price, brand, hasRGB, powerConsumption, name, description);
        this.modelName = modelName;
        this.coreCount = coreCount;
        this.hasIntegratedGraphics = hasIntegratedGraphics;
        this.socketType = socketType;
    }

    public String getSocketType() { return socketType; }
    public boolean hasIntegratedGraphics() { return hasIntegratedGraphics; }
    public int getCoreCount(){ return coreCount; }
}

class Motherboard extends Component {
    private int maxRamCapacityGB;
    private int ramSlots;
    private String socketCompatibility; // e.g., "LGA1700", "AM4", "AM5"
    private String chipset;
    private String formFactor; // e.g., "ATX", "Micro-ATX", "ITX"

    public Motherboard(double price, String brand, boolean hasRGB, int powerConsumption, String name, String description, int maxRamCapacityGB, int ramSlots, String socketCompatibility, String chipset, String formFactor) {
        super(price, brand, hasRGB, powerConsumption, name, description);
        this.maxRamCapacityGB = maxRamCapacityGB;
        this.ramSlots = ramSlots;
        this.socketCompatibility = socketCompatibility;
        this.chipset = chipset;
        this.formFactor = formFactor;
    }

    public String getSocketCompatibility() { return socketCompatibility; }
    public int getRamSlots() { return ramSlots; }
    public String getFormFactor() { return formFactor; }
}

class GPU extends Component {
    private int vramGB;
    private int coreClockMHz;
    private int boostClockMHz;
    private String apiSupport;

    public GPU(double price, String brand, boolean hasRGB, int powerConsumption, String name, String description, int vramGB, int coreClockMHz, int boostClockMHz, String apiSupport) {
        super(price, brand, hasRGB, powerConsumption, name, description);
        this.vramGB = vramGB;
        this.coreClockMHz = coreClockMHz;
        this.boostClockMHz = boostClockMHz;
        this.apiSupport = apiSupport;
    }
    public int getVramGB() { return vramGB; }
}

class RAM extends Component {
    private int generation; // e.g., 4 for DDR4, 5 for DDR5
    private int capacityGB;
    private int speedMHz;
    private String type; // e.g., "DDR4", "DDR5"

    public RAM(double price, String brand, boolean hasRGB, int powerConsumption, String name, String description, int generation, int capacityGB, int speedMHz, String type) {
        super(price, brand, hasRGB, powerConsumption, name, description);
        this.generation = generation;
        this.capacityGB = capacityGB;
        this.speedMHz = speedMHz;
        this.type = type;
    }
    public String getType() { return type; }
    public int getCapacityGB() { return capacityGB; }
}

class Storage extends Component {
    private int capacityGB;
    private int speedMBps;
    private String type; // "SSD" or "HDD"

    public Storage(double price, String brand, boolean hasRGB, int powerConsumption, String name, String description, int capacityGB, int speedMBps, String type) {
        super(price, brand, hasRGB, powerConsumption, name, description);
        this.capacityGB = capacityGB;
        this.speedMBps = speedMBps;
        this.type = type;
    }
    public String getType() { return type; }
    public int getCapacityGB() { return capacityGB; }
}

class Case extends Component {
    private String caseType;
    private String dimensions;
    private String frontPanelIO;
    private int includedFans;

    public Case(double price, String brand, boolean hasRGB, int powerConsumption, String name, String description, String caseType, String dimensions, String frontPanelIO, int includedFans) {
        // Set power consumption to 0 for case for total system load calculation purposes
        super(price, brand, hasRGB, 0, name, description);
        this.caseType = caseType;
        this.dimensions = dimensions;
        this.frontPanelIO = frontPanelIO;
        this.includedFans = includedFans;
    }
    public String getCaseType() { return caseType; }
}

// New Component: CoolingSystem
class CoolingSystem extends Component {
    private String coolingType; // e.g., "Air Cooler", "AIO Liquid Cooler", "Custom Loop Fan Kit"

    public CoolingSystem(double price, String brand, boolean hasRGB, int powerConsumption, String name, String description, String coolingType) {
        super(price, brand, hasRGB, powerConsumption, name, description);
        this.coolingType = coolingType;
    }
    public String getCoolingType() { return coolingType; }
}

class PSU extends Component {
    private int wattage;
    private String powerSupplyRating; // e.g., "80+ Bronze", "80+ Gold"

    public PSU(double price, String brand, boolean hasRGB, int powerConsumption, String name, String description, int wattage, String powerSupplyRating) {
        // Set power consumption to 0 for PSU for total system load calculation purposes
        super(price, brand, hasRGB, 0, name, description);
        this.wattage = wattage;
        this.powerSupplyRating = powerSupplyRating;
    }
    public int getWattage() { return wattage; }
    public String getPowerSupplyRating() { return powerSupplyRating; }
}

class UPS extends Component {
    private int vaRating; // Volt-Amps (Capacity)


    public UPS(double price, String brand, boolean hasRGB, int powerConsumption, String name, String description, int vaRating) {
        // UPS has its own power consumption (for charging/standby)
        super(price, brand, hasRGB, powerConsumption, name, description);
        this.vaRating = vaRating;
    }
    public int getVaRating() { return vaRating; }
}


public class CustomPCBuilder {
    Scanner scanner = new Scanner(System.in);
    double totalCost = 0;
    int totalPowerConsumption = 0; // To estimate PSU requirements (sum of selected components' consumption)

    // Selected components for the current build
    CPU selectedCPU = null;
    Motherboard selectedMotherboard = null;
    GPU selectedGPU = null;
    RAM selectedRAM = null;
    Storage selectedStorage = null;
    Case selectedCase = null;
    CoolingSystem selectedCoolingSystem = null; // New component
    PSU selectedPSU = null;
    UPS selectedUPS = null;

    // --- Component Inventory ---
    CPU intelCorei3_12100 = new CPU(119.99, "Intel", false, 60, "Core i3-12100", "Budget 4-core CPU", "i3-12100", 4, true, "LGA1700");
    CPU i5_13600K = new CPU(280.0, "Intel", false, 125, "Core i5-13600K", "Mid-range 14-core CPU", "i5-13600K", 14, true, "LGA1700");
    CPU ryzen5_7600X = new CPU(230.0, "AMD", false, 105, "Ryzen 5 7600X", "AM5 6-core CPU", "Ryzen 5 7600X", 6, true, "AM5");
    CPU ryzen7_7800X3D = new CPU(449.0, "AMD", false, 120, "Ryzen 7 7800X3D", "Top AM5 gaming CPU", "Ryzen 7 7800X3D", 8, true, "AM5");
    CPU ryzen5_5600X = new CPU(150.0, "AMD", false, 65, "Ryzen 5 5600X", "Great value AM4 6-core CPU", "Ryzen 5 5600X", 6, false, "AM4");

    // Motherboards (Updated and New)
    Motherboard b650m_ds3h = new Motherboard(120.00, "Gigabyte", false, 15, "B650M DS3H", "Budget AM5 Micro-ATX", 192, 4, "AM5", "B650", "Micro-ATX"); // Max RAM updated
    Motherboard z790_aorus_elite = new Motherboard(250.00, "Gigabyte", true, 25, "Z790 Aorus Elite AX", "LGA1700 ATX for DDR5", 192, 4, "LGA1700", "Z790", "ATX");
    Motherboard b550_tomahawk = new Motherboard(160.00, "MSI", false, 20, "B550 Tomahawk", "Solid AM4 ATX", 128, 4, "AM4", "B550", "ATX");
    Motherboard a620m_itx = new Motherboard(100.00, "ASRock", false, 10, "A620M-ITX WiFi", "Compact AM5 ITX", 96, 2, "AM5", "A620", "ITX"); // Max RAM updated
    // New Motherboards
    Motherboard asus_x670e_f_wifi = new Motherboard(399.99, "ASUS", true, 25, "ROG STRIX X670E-F GAMING WIFI", "High-end AM5 ATX, PCIe 5.0", 192, 4, "AM5", "X670E", "ATX");
    Motherboard msi_b760_tomahawk_wifi = new Motherboard(199.99, "MSI", true, 20, "MAG B760 TOMAHAWK WIFI", "Mid-range LGA1700 ATX for DDR5", 192, 4, "LGA1700", "B760", "ATX");
    Motherboard gigabyte_b650_aorus_elite_ice = new Motherboard(219.99, "Gigabyte", true, 20, "B650 AORUS Elite AX ICE", "White-themed AM5 ATX", 192, 4, "AM5", "B650", "ATX");

    // GPUs (Existing - No )
    GPU rtx4060 = new GPU(329.00, "NVIDIA", true, 115, "GeForce RTX 4060", "1080p gaming", 8, 1830, 2460, "NVIDIA");
    GPU rx7800xt = new GPU(499.00, "AMD", true, 263, "Radeon RX 7800XT", "1440p gaming", 16, 2124, 2430, "AMD");
    GPU rtx4070super = new GPU(599.00, "NVIDIA", true, 220, "GeForce RTX 4070 Super", "1440p/4K GPU", 12, 1980, 2475, "NVIDIA");
    GPU rx6600 = new GPU(200.00, "AMD", false, 132, "Radeon RX 6600", "Budget 1080p GPU", 8, 1626, 2491, "AMD");

    // RAM (Updated and New)
    RAM ddr5_32gb_6000 = new RAM(99.00, "Corsair", true, 12, "Vengeance RGB 32GB DDR5 6000", "32GB (2x16) DDR5 6000MHz CL30", 5, 32, 6000, "DDR5");
    RAM ddr4_16gb_3200 = new RAM(45.00, "Crucial", false, 8, "Ballistix 16GB DDR4 3200", "16GB (2x8) DDR4 3200MHz CL16", 4, 16, 3200, "DDR4");
    RAM ddr5_16gb_5200 = new RAM(55.00, "Kingston", false, 10, "Fury Beast 16GB DDR5 5200", "16GB (2x8) DDR5 5200MHz CL40", 5, 16, 5200, "DDR5");
    // New RAM
    RAM corsair_lpx_32gb_ddr4_3600 = new RAM(74.99, "Corsair", false, 10, "Vengeance LPX 32GB DDR4 3600MHz", "32GB (2x16) DDR4 3600MHz CL18", 4, 32, 3600, "DDR4");
    RAM gskill_trident_z5_32gb_ddr5_6000 = new RAM(109.99, "G.Skill", true, 12, "Trident Z5 RGB 32GB DDR5 6000MHz", "32GB (2x16) DDR5 6000MHz CL30, AMD EXPO", 5, 32, 6000, "DDR5");
    RAM kingston_fury_64gb_ddr5_5600 = new RAM(199.99, "Kingston", true, 15, "Fury Beast RGB 64GB DDR5 5600MHz", "64GB (2x32) DDR5 5600MHz CL40", 5, 64, 5600, "DDR5");

    // Storage (Updated and New)
    Storage nvme_1tb_sn770 = new Storage(70.00, "WD", false, 7, "Black SN770 1TB NVMe", "Fast 1TB PCIe 4.0 NVMe SSD", 1000, 5150, "SSD");
    Storage sata_2tb_mx500 = new Storage(110.00, "Crucial", false, 5, "MX500 2TB SATA SSD", "Reliable 2TB SATA SSD", 2000, 560, "SSD");
    Storage hdd_4tb_barracuda = new Storage(80.00, "Seagate", false, 10, "Barracuda 4TB HDD", "Large 4TB HDD, 5400 RPM", 4000, 190, "HDD");
    // New Storage
    Storage samsung_990_pro_2tb = new Storage(169.99, "Samsung", false, 8, "990 Pro 2TB NVMe SSD", "Top-tier 2TB PCIe 4.0 NVMe SSD", 2000, 7450, "SSD");
    Storage crucial_p3_plus_4tb = new Storage(199.99, "Crucial", false, 7, "P3 Plus 4TB NVMe SSD", "Large capacity 4TB PCIe 4.0 NVMe SSD", 4000, 5000, "SSD");
    Storage seagate_ironwolf_8tb = new Storage(199.99, "Seagate", false, 10, "IronWolf 8TB HDD", "Reliable 8TB NAS HDD, 7200 RPM", 8000, 200, "HDD");

    // Cases (Existing)
    Case fractalPopAir = new Case(89.00, "Fractal Design", true, 0, "Pop Air RGB", "Mid-tower ATX case", "ATX Mid Tower", "473x215x454mm", "2xUSB 3.0, Audio", 3);
    Case lianLiO11Dynamic = new Case(149.00, "Lian Li", false, 0, "O11 Dynamic EVO", "Premium ATX Mid-tower", "ATX Mid Tower", "465x285x459mm", "2xUSB 3.0, 1xUSB-C, Audio", 0);
    Case nr200p = new Case(99.00, "Cooler Master", false, 0, "MasterBox NR200P", "Popular ITX SFF case", "ITX Small Form Factor", "376x185x292mm", "2xUSB 3.2 Gen 1, Audio", 2);
    Case microATXQ300L = new Case(50.00, "Cooler Master", false, 0, "MasterBox Q300L", "Compact Micro-ATX Tower", "Micro-ATX Tower", "387x230x381mm", "2xUSB 3.0, Audio", 1);

    // Cooling Systems (Existing)
    CoolingSystem peerlessAssassin = new CoolingSystem(40.00, "Thermalright", false, 5, "Peerless Assassin 120", "Dual tower air cooler", "Air Cooler");
    CoolingSystem ls720 = new CoolingSystem(130.00, "Deepcool", true, 15, "LS720 AIO", "360mm AIO liquid cooler", "AIO Liquid Cooler");
    CoolingSystem noctuaNHU12S = new CoolingSystem(70.00, "Noctua", false, 3, "NH-U12S Redux", "Single tower air cooler", "Air Cooler");

    // PSUs (Existing)
    PSU corsairRM750e = new PSU(99.00, "Corsair", false, 0, "RM750e", "750W Gold PSU", 750, "80+ Gold");
    PSU seasonicFocusGX850 = new PSU(129.00, "Seasonic", false, 0, "Focus GX-850", "850W Gold PSU", 850, "80+ Gold");
    PSU msiA650BN = new PSU(65.00, "MSI", false, 0, "MAG A650BN", "650W Bronze PSU", 650, "80+ Bronze");
    PSU evga500W = new PSU(45.00, "EVGA", false, 0, "500 W1", "500W 80+ White PSU", 500, "80+ White");
    PSU cheap= new PSU(30.00, "Generic", false, 0, "Generic 100W Bomb", "100W PSU", 100, "0+ White");

    // UPS (Existing)
    UPS cyberPower1500VA = new UPS(170.00, "CyberPower", false, 10, "CP1500PFCLCD", "1500VA Sine Wave UPS", 1500);
    UPS apcBackUPS600VA = new UPS(80.00, "APC", false, 5, "BE600M1", "600VA UPS", 600);

    public static void main(String[] args) {
        new CustomPCBuilder().run();
    }

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Custom PC Builder ---");
            System.out.println("Current Total Cost: $" + String.format("%.2f", totalCost));
            System.out.println("Estimated Power Consumption: " + totalPowerConsumption + "W");
            System.out.println("1. Start/Continue Building");
            System.out.println("2. View Current Build");
            System.out.println("3. Reset Build");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    buildCustomPC();
                    break;
                case 2:
                    viewCurrentBuild();
                    break;
                case 3:
                    resetBuild();
                    System.out.println("Build has been reset.");
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting PC Builder. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private void resetBuild() {
        totalCost = 0;
        totalPowerConsumption = 0;
        selectedCPU = null;
        selectedMotherboard = null;
        selectedGPU = null;
        selectedRAM = null;
        selectedStorage = null;
        selectedCase = null;
        selectedCoolingSystem = null;
        selectedPSU = null;
        selectedUPS = null;
    }

    private void viewCurrentBuild() {
        System.out.println("\n--- Current PC Configuration ---");
        if (selectedCPU == null && selectedMotherboard == null && selectedGPU == null && selectedRAM == null &&
            selectedStorage == null && selectedCase == null && selectedCoolingSystem == null && selectedPSU == null && selectedUPS == null) {
            System.out.println("No components selected yet.");
            return;
        }
        if (selectedCPU != null) System.out.println("CPU: " + selectedCPU);
        if (selectedMotherboard != null) System.out.println("Motherboard: " + selectedMotherboard);
        if (selectedGPU != null) System.out.println("GPU: " + selectedGPU);
        if (selectedRAM != null) System.out.println("RAM: " + selectedRAM);
        if (selectedStorage != null) System.out.println("Storage: " + selectedStorage);
        if (selectedCase != null) System.out.println("Case: " + selectedCase);
        if (selectedCoolingSystem != null) System.out.println("Cooling: " + selectedCoolingSystem);
        if (selectedPSU != null) System.out.println("PSU: " + selectedPSU);
        if (selectedUPS != null) System.out.println("UPS: " + selectedUPS);
        System.out.println("---------------------------------");
        System.out.println("Total Estimated Component Power Draw: " + totalPowerConsumption + "W (Excludes PSU/Case self-draw)");
        System.out.println("Total Cost: $" + String.format("%.2f", totalCost));
        System.out.println("---------------------------------");
    }


    public void buildCustomPC() {
        final int TOTAL_MAIN_STEPS = 8; // CPU, Mobo, GPU, RAM, Storage, Case, Cooling, PSU
        int currentStep = 0;

        // Determine starting step (if some components are already selected)
        if (selectedCPU != null) currentStep = 1;
        if (selectedMotherboard != null) currentStep = 2;
        if (selectedGPU != null) currentStep = 3;
        if (selectedRAM != null) currentStep = 4;
        if (selectedStorage != null) currentStep = 5;
        if (selectedCase != null) currentStep = 6;
        if (selectedCoolingSystem != null) currentStep = 7;
        if (selectedPSU != null) currentStep = 8;


        while (currentStep < TOTAL_MAIN_STEPS) {
            System.out.println("\n--- Step " + (currentStep + 1) + " of " + TOTAL_MAIN_STEPS + " ---");
            System.out.println("Current Total Cost: $" + String.format("%.2f", totalCost) + " | Estimated Component Power: " + totalPowerConsumption + "W");

            Component selectedComponent = null; // Use a generic variable for the component being selected in this step

            switch (currentStep) {
                case 0: // CPU
                    // Remove cost/power of old selection if exists
                    if (selectedCPU != null) {
                        totalCost -= selectedCPU.getPrice();
                        totalPowerConsumption -= selectedCPU.getPowerConsumption();
                        // If CPU changes, dependent components like Motherboard become potentially incompatible
                        if (selectedMotherboard != null) {
                            System.out.println("CPU changed, removing incompatible Motherboard ("+selectedMotherboard.getName()+").");
                            totalCost -= selectedMotherboard.getPrice();
                            totalPowerConsumption -= selectedMotherboard.getPowerConsumption();
                            selectedMotherboard = null;
                            // Also potentially remove RAM if DDR generation depends on motherboard (not implemented yet)
                             if(selectedRAM != null /* && logic to check if RAM depends on old mobo */){
                                 System.out.println("Motherboard changed, removing RAM selection ("+selectedRAM.getName()+").");
                                 totalCost -= selectedRAM.getPrice();
                                 totalPowerConsumption -= selectedRAM.getPowerConsumption();
                                 selectedRAM = null;
                             }
                        }
                         if (selectedCoolingSystem != null){
                             System.out.println("CPU changed, removing Cooling System selection ("+selectedCoolingSystem.getName()+"). Compatibility should be re-checked.");
                             totalCost -= selectedCoolingSystem.getPrice();
                             totalPowerConsumption -= selectedCoolingSystem.getPowerConsumption();
                             selectedCoolingSystem = null;
                         }
                    }
                    selectedComponent = selectCPU();
                    if (selectedComponent != null) {
                        selectedCPU = (CPU) selectedComponent;
                    }
                    break;
                case 1: // Motherboard
                     // Remove cost/power of old selection if exists
                    if (selectedMotherboard != null) {
                         totalCost -= selectedMotherboard.getPrice();
                         totalPowerConsumption -= selectedMotherboard.getPowerConsumption();
                         // If Motherboard changes, RAM and possibly Storage compatibility needs re-checking
                         if(selectedRAM != null /* && logic to check if RAM depends on old mobo */){
                             System.out.println("Motherboard changed, removing RAM selection ("+selectedRAM.getName()+"). Compatibility should be re-checked.");
                             totalCost -= selectedRAM.getPrice();
                             totalPowerConsumption -= selectedRAM.getPowerConsumption();
                             selectedRAM = null;
                         }
                         // Could also remove Storage here if connection types (SATA/NVMe) are motherboard dependent
                         // if(selectedStorage != null){ ... }
                    }
                    selectedComponent = selectMotherboard(currentStep);
                     if (selectedComponent != null) {
                        selectedMotherboard = (Motherboard) selectedComponent;
                    }
                    break;
                case 2: // GPU
                    if (selectedGPU != null) {
                        totalCost -= selectedGPU.getPrice();
                        totalPowerConsumption -= selectedGPU.getPowerConsumption();
                    }
                    selectedComponent = selectGPU();
                     if (selectedComponent != null) {
                        selectedGPU = (GPU) selectedComponent;
                    }
                    break;
                case 3: // RAM
                    if (selectedRAM != null) {
                        totalCost -= selectedRAM.getPrice();
                        totalPowerConsumption -= selectedRAM.getPowerConsumption();
                    }
                    selectedComponent = selectRAM();
                     if (selectedComponent != null) {
                        selectedRAM = (RAM) selectedComponent;
                    }
                    break;
                case 4: // Storage
                     if (selectedStorage != null) {
                        totalCost -= selectedStorage.getPrice();
                        totalPowerConsumption -= selectedStorage.getPowerConsumption();
                    }
                    selectedComponent = selectStorage();
                    if (selectedComponent != null) {
                         selectedStorage = (Storage) selectedComponent;
                    }
                    break;
                case 5: // Case
                    if (selectedCase != null) {
                        totalCost -= selectedCase.getPrice();
                        // Power consumption for Case is not added to totalPowerConsumption
                        // totalPowerConsumption -= selectedCase.getPowerConsumption();
                    }
                    selectedComponent = selectCase();
                     if (selectedComponent != null) {
                        selectedCase = (Case) selectedComponent;
                    }
                    break;
                case 6: // Cooling System
                    if (selectedCoolingSystem != null) {
                         totalCost -= selectedCoolingSystem.getPrice();
                         totalPowerConsumption -= selectedCoolingSystem.getPowerConsumption();
                    }
                    selectedComponent = selectCoolingSystem();
                     if (selectedComponent != null) {
                        selectedCoolingSystem = (CoolingSystem) selectedComponent;
                    }
                    break;
                case 7: // PSU
                     if (selectedPSU != null) {
                        totalCost -= selectedPSU.getPrice();
                         // Power consumption for PSU is not added to totalPowerConsumption
                         // totalPowerConsumption -= selectedPSU.getPowerConsumption();
                    }
                    selectedComponent = selectPSU();
                     if (selectedComponent != null) {
                        selectedPSU = (PSU) selectedComponent;
                    }
                    break;
            }

            // --- Handle selection result and advance step ---
            if (selectedComponent != null) {
                // Successfully selected a component
                totalCost += selectedComponent.getPrice();
                // Add power consumption only for components that contribute significantly to system load
                if (!(selectedComponent instanceof PSU) && !(selectedComponent instanceof Case)) {
                     totalPowerConsumption += selectedComponent.getPowerConsumption();
                }

                System.out.println(selectedComponent.getName() + " selected.");
                currentStep++; // Move to the next step
            } else {
                // User chose to go back (input -1)
                if (currentStep > 0) {
                    currentStep--; // Go back to the previous step
                    System.out.println("Going back to select " + getStepName(currentStep) + ".");
                    // The cost/power of the component from the step we just left
                    // was removed at the start of this iteration's case block
                    // if a component was previously selected.
                } else {
                    System.out.println("Cannot go back further. Returning to main menu.");
                    return; // Exit build process, back to main menu
                }
            }
        }

        // After the main steps, offer the optional UPS
        if (currentStep == TOTAL_MAIN_STEPS) {
            System.out.println("\nAll main components selected!");
            selectOptionalUPS();
            finalizeBuild();
        }
    }

    private String getStepName(int stepIndex) {
        switch(stepIndex) {
            case 0: return "CPU";
            case 1: return "Motherboard";
            case 2: return "GPU";
            case 3: return "RAM";
            case 4: return "Storage";
            case 5: return "Case";
            case 6: return "Cooling System";
            case 7: return "PSU";
            default: return "Unknown Component";
        }
    }

    private void selectOptionalUPS() {
         if (selectedUPS != null) { // If already selected and coming back to change/remove
             System.out.println("\n--- Optional: Change/Remove UPS ---");
             System.out.println("Current UPS: " + selectedUPS.getName());
             totalCost -= selectedUPS.getPrice();
             totalPowerConsumption -= selectedUPS.getPowerConsumption(); // Remove old UPS power
             selectedUPS = null;
         } else {
             System.out.println("\n--- Optional: Select UPS ---");
             System.out.println("Would you like to add a UPS (Uninterruptible Power Supply)?");
             System.out.println("1. Yes");
             System.out.println("2. No, skip UPS");
             System.out.print("Choose an option: ");
             int choice = getIntInput();

             if (choice != 1) {
                 System.out.println("No UPS will be added.");
                 return; // Skip UPS selection
             }
         }

        // Proceed to select UPS if Yes was chosen or if changing/removing
        UPS newUPS = selectUPS(); // This is the actual selection method
        if (newUPS != null) {
            selectedUPS = newUPS;
            totalCost += selectedUPS.getPrice();
            totalPowerConsumption += selectedUPS.getPowerConsumption(); // UPS itself consumes a little power
            System.out.println(selectedUPS.getName() + " added to build.");
        } else {
            System.out.println("No UPS selected or went back.");
        }
    }

    private void finalizeBuild() {
        System.out.println("\n--- Build Finalized ---");
        viewCurrentBuild(); // Shows the complete list and totals
        System.out.println("Congratulations on your custom PC configuration!");
        // Options to save, start new, or exit are handled by the main run() loop
    }

    // Generic method to display options and get validated input
    private <T extends Component> T presentOptionsAndSelect(String componentType, List<T> options, boolean canGoBack) {
        System.out.println("\nSelect a " + componentType + (canGoBack ? " (or enter -1 to go back):" : ":"));
        if (options.isEmpty()) {
            System.out.println("No compatible " + componentType + " options available based on current selections.");
             // Provide hints if crucial dependencies are missing/incompatible
            if(componentType.equals("Motherboard") && selectedCPU == null) {
                 System.out.println("Hint: Please select a CPU first to see compatible motherboards.");
             } else if (componentType.equals("Motherboard") && selectedCPU != null) {
                  System.out.println("Hint: No motherboards matching CPU socket " + selectedCPU.getSocketType() + " found in inventory.");
             }
             // Add more hints for other dependencies if needed (e.g., RAM type for Mobo)

            // Force user to go back if no options are available, unless it's the first step (CPU)
             if(canGoBack || componentType.equals("CPU")){ // Allow going back if possible, or if it's the very first selection
                 System.out.print("Enter -1 to go back: ");
                 int choice = getIntInput();
                 if(choice == -1) return null;
             }
             System.out.println("Cannot proceed. Returning to previous step.");
             return null; // Indicate selection failed
        }

        for (int i = 0; i < options.size(); i++) {
            System.out.println(i + ": " + options.get(i).toString());
        }
        System.out.print("Choose index" + (canGoBack ? " (or -1 to go back)" : "") + ": ");

        int choice = getIntInput();

        if (canGoBack && choice == -1) {
            return null; // Signal to go back
        }
        if (choice >= 0 && choice < options.size()) {
            return options.get(choice);
        } else {
            System.out.println("Invalid choice. Please select again.");
            return presentOptionsAndSelect(componentType, options, canGoBack); // Recursive call for retry
        }
    }

    private int getIntInput() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
            }
        }
    }


    // --- Individual Component Selection Methods ---
    private CPU selectCPU() {
        List<CPU> cpus = new ArrayList<>();
        cpus.add(intelCorei3_12100);
        cpus.add(i5_13600K);
        cpus.add(ryzen5_7600X);
        cpus.add(ryzen7_7800X3D);
        // Allow going back if a CPU has already been selected or if a Motherboard has been selected (as changing CPU affects Mobo)
        return presentOptionsAndSelect("CPU", cpus, selectedCPU != null || selectedMotherboard != null);
    }

    private Motherboard selectMotherboard(int currentStep) {
        List<Motherboard> allMotherboards = new ArrayList<>();
        // Existing
        allMotherboards.add(b650m_ds3h); allMotherboards.add(z790_aorus_elite);
        allMotherboards.add(b550_tomahawk); allMotherboards.add(a620m_itx);
        // New
        allMotherboards.add(asus_x670e_f_wifi); allMotherboards.add(msi_b760_tomahawk_wifi);
        allMotherboards.add(gigabyte_b650_aorus_elite_ice);
        // ... rest of the filtering logic
        // ...
        if (selectedCPU == null) {
        return presentOptionsAndSelect("Motherboard", allMotherboards, selectedMotherboard != null || currentStep > 1);
        }
        // ... (filtering logic remains the same)
        String requiredSocket = selectedCPU.getSocketType();
        List<Motherboard> compatibleMotherboards = allMotherboards.stream()
            .filter(m -> m.getSocketCompatibility().equals(requiredSocket))
            .collect(Collectors.toList());
        
        if (compatibleMotherboards.isEmpty()){
            System.out.println("No motherboards found in inventory for CPU socket: " + requiredSocket + ". Showing all motherboards.");
            compatibleMotherboards = allMotherboards; // Fallback to show all if no direct match
        }
        return presentOptionsAndSelect("Motherboard", compatibleMotherboards, selectedMotherboard != null || currentStep > 1);
    }

    private GPU selectGPU() {
        List<GPU> gpus = new ArrayList<>();
        gpus.add(rtx4060);
        gpus.add(rx7800xt);
        gpus.add(rtx4070super);
        gpus.add(rx6600);

         return presentOptionsAndSelect("GPU", gpus, selectedGPU != null);
    }

    private RAM selectRAM() {
        List<RAM> rams = new ArrayList<>();
        // Basic filtering by DDR generation based on Motherboard if selected (requires Motherboard class to have getRamType)
        // For now, present all RAM if no motherboard selected or if motherboard has no ram type info
        if (selectedMotherboard != null) {
            // Add logic here to filter RAM based on Motherboard's RAM type (e.g., DDR4 or DDR5)
            // Example (assuming Motherboard had a getRamType() method):
            // if (selectedMotherboard.getRamType().equals("DDR5")) {
            //     rams.add(ddr5_32gb_6000);
            // } else if (selectedMotherboard.getRamType().equals("DDR4")) {
            //     rams.add(ddr4_16gb_3200);
            // }
             // Since Motherboard does not have getRamType(), we add all RAM for now, but log a warning
            System.out.println("Warning: RAM type compatibility with the selected motherboard is not currently enforced.");
            rams.add(ddr5_32gb_6000);
            rams.add(ddr4_16gb_3200);
            rams.add(ddr5_16gb_5200);
            rams.add(corsair_lpx_32gb_ddr4_3600);
            rams.add(gskill_trident_z5_32gb_ddr5_6000);
            rams.add(kingston_fury_64gb_ddr5_5600);


        } else {
             // If no motherboard is selected, offer all RAM but warn
             System.out.println("Warning: Cannot filter RAM by motherboard compatibility as no motherboard is selected.");
            rams.add(ddr5_32gb_6000);
            rams.add(ddr4_16gb_3200);
        }


        // Allow going back if RAM has already been selected
        return presentOptionsAndSelect("RAM", rams, selectedRAM != null);
    }

    private Storage selectStorage() {
        List<Storage> storages = new ArrayList<>();
        storages.add(nvme_1tb_sn770);
        storages.add(sata_2tb_mx500);
        storages.add(hdd_4tb_barracuda);
        storages.add(samsung_990_pro_2tb);
        storages.add(crucial_p3_plus_4tb);
        storages.add(seagate_ironwolf_8tb);

         // Allow going back if Storage has already been selected
         // Note: Storage type (SSD/HDD) is not enforced in this version
         // Could be added as a filter based on Motherboard or other criteria
        // Allow going back if Storage has already been selected
        return presentOptionsAndSelect("Storage", storages, selectedStorage != null);
    }

    private Case selectCase() {
        List<Case> cases = new ArrayList<>();
        cases.add(fractalPopAir);
        cases.add(lianLiO11Dynamic);
        cases.add(nr200p);
        cases.add(microATXQ300L);

         // Allow going back if a Case has already been selected
        return presentOptionsAndSelect("Case", cases, selectedCase != null);
    }

    private CoolingSystem selectCoolingSystem() {
        List<CoolingSystem> coolers = new ArrayList<>();
        coolers.add(peerlessAssassin);
        coolers.add(ls720);
        coolers.add(noctuaNHU12S);

         // Allow going back if Cooling System has already been selected
        return presentOptionsAndSelect("Cooling System", coolers, selectedCoolingSystem != null);
    }

    private PSU selectPSU() {
        System.out.println("Recommended PSU Wattage based on selected components: ~" + (totalPowerConsumption + 100) + "W (includes ~100W headroom).");
        List<PSU> psus = new ArrayList<>();
        psus.add(msiA650BN); // 650W
        psus.add(corsairRM750e); // 750W
        psus.add(seasonicFocusGX850); // 850W
        psus.add(evga500W); // 500W
        psus.add(cheap); // 100W PSU for testing
         // Allow going back if a PSU has already been selected
        return presentOptionsAndSelect("PSU", psus, selectedPSU != null);
    }

     private UPS selectUPS() {
        List<UPS> upsOptions = new ArrayList<>();
        upsOptions.add(cyberPower1500VA);
        upsOptions.add(apcBackUPS600VA);
        
         // Allow going back if a UPS has already been selected
        return presentOptionsAndSelect("UPS", upsOptions, selectedUPS != null);
     }
}