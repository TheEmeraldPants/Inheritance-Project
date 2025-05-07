import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// Base class for all PC components (aligned with user's preference)
abstract class Component {
    protected double price;
    protected String brand;
    protected boolean hasRGB;
    protected int powerConsumption; // Estimated power consumption in Watts
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
        super(price, brand, hasRGB, powerConsumption, name, description); // Case power consumption is usually negligible, for its own LEDs/fans if not powered by PSU directly
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
        super(price, brand, hasRGB, powerConsumption, name, description); // PSU's own consumption is minimal
        this.wattage = wattage;
        this.powerSupplyRating = powerSupplyRating;
    }
    public int getWattage() { return wattage; }
    public String getPowerSupplyRating() { return powerSupplyRating; }
}

class UPS extends Component {
    private int vaRating; // Volt-Amps (Capacity)

    public UPS(double price, String brand, boolean hasRGB, int powerConsumption, String name, String description, int vaRating) {
        super(price, brand, hasRGB, powerConsumption, name, description); // UPS's own consumption
        this.vaRating = vaRating;
    }
    public int getVaRating() { return vaRating; }
}


public class CustomPCBuilder {
    Scanner scanner = new Scanner(System.in);
    double totalCost = 0;
    int totalPowerConsumption = 0; // To estimate PSU requirements

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
    // CPUs
    CPU intelCorei3_12100 = new CPU(119.99, "Intel", false, 60, "Core i3-12100", "Budget 4-core CPU with integrated graphics", "i3-12100", 4, true, "LGA1700");
    CPU i5_13600K = new CPU(280.0, "Intel", false, 125, "Core i5-13600K", "Mid-range 14-core CPU, great for gaming", "i5-13600K", 14, true, "LGA1700");
    CPU ryzen5_7600X = new CPU(230.0, "AMD", false, 105, "Ryzen 5 7600X", "Excellent value AM5 6-core CPU", "Ryzen 5 7600X", 6, true, "AM5");
    CPU ryzen7_7800X3D = new CPU(449.0, "AMD", false, 120, "Ryzen 7 7800X3D", "Top-tier AM5 gaming CPU with 3D V-Cache", "Ryzen 7 7800X3D", 8, true, "AM5");

    // Motherboards
    Motherboard b650m_ds3h = new Motherboard(120.00, "Gigabyte", false, 15, "B650M DS3H", "Budget AM5 Micro-ATX board", 128, 4, "AM5", "B650", "Micro-ATX");
    Motherboard z790_aorus_elite = new Motherboard(250.00, "Gigabyte", true, 25, "Z790 Aorus Elite AX", "Feature-rich LGA1700 ATX board with WiFi", 192, 4, "LGA1700", "Z790", "ATX");
    Motherboard b550_tomahawk = new Motherboard(160.00, "MSI", false, 20, "B550 Tomahawk", "Solid AM4 ATX board", 128, 4, "AM4", "B550", "ATX"); // Example for AM4 CPU if added

    // GPUs
    GPU rtx4060 = new GPU(329.00, "NVIDIA", true, 115, "GeForce RTX 4060", "Good for 1080p gaming", 8, 1830, 2460, "NVIDIA");
    GPU rx7800xt = new GPU(499.00, "AMD", true, 263, "Radeon RX 7800XT", "Excellent for 1440p gaming", 16, 2124, 2430, "AMD");
    GPU rtx4070super = new GPU(599.00, "NVIDIA", true, 220, "GeForce RTX 4070 Super", "High-performance 1440p/4K GPU", 12, 1980, 2475, "NVIDIA");

    // RAM
    RAM ddr5_32gb_6000 = new RAM(99.00, "Corsair", true, 12, "Vengeance RGB 32GB DDR5 6000MHz", "32GB (2x16GB) DDR5 6000MHz CL30 kit", 5, 32, 6000, "DDR5");
    RAM ddr4_16gb_3200 = new RAM(45.00, "Crucial", false, 8, "Ballistix 16GB DDR4 3200MHz", "16GB (2x8GB) DDR4 3200MHz CL16 kit", 4, 16, 3200, "DDR4");

    // Storage
    Storage nvme_1tb_sn770 = new Storage(70.00, "WD", false, 7, "Black SN770 1TB NVMe SSD", "Fast 1TB NVMe SSD for OS and games", 1000, 5150, "SSD");
    Storage sata_2tb_mx500 = new Storage(110.00, "Crucial", false, 5, "MX500 2TB SATA SSD", "Reliable 2TB SATA SSD for general storage", 2000, 560, "SSD");
    Storage hdd_4tb_barracuda = new Storage(80.00, "Seagate", false, 10, "Barracuda 4TB HDD", "Large capacity 4TB HDD for media", 4000, 190, "HDD");

    // Cases
    Case fractalPopAir = new Case(89.00, "Fractal Design", true, 5, "Pop Air RGB", "Mid-tower ATX case with good airflow and RGB fans", "Mid Tower", "473x215x454mm", "2xUSB 3.0, Audio", 3);
    Case lianLiO11Dynamic = new Case(149.00, "Lian Li", false, 0, "O11 Dynamic EVO", "Premium Mid-tower ATX case, requires separate fans", "Mid Tower", "465x285x459mm", "2xUSB 3.0, 1xUSB-C, Audio", 0);

    // Cooling Systems
    CoolingSystem peerlessAssassin = new CoolingSystem(40.00, "Thermalright", false, 5, "Peerless Assassin 120", "High-performance dual tower air cooler", "Air Cooler");
    CoolingSystem ls720 = new CoolingSystem(130.00, "Deepcool", true, 15, "LS720 AIO", "360mm AIO liquid cooler with RGB", "AIO Liquid Cooler");
    CoolingSystem noctuaNHU12S = new CoolingSystem(70.00, "Noctua", false, 3, "NH-U12S Redux", "Quiet and efficient single tower air cooler", "Air Cooler");


    // PSUs
    PSU corsairRM750e = new PSU(99.00, "Corsair", false, 2, "RM750e", "750W Gold rated PSU, reliable", 750, "80+ Gold");
    PSU seasonicFocusGX850 = new PSU(129.00, "Seasonic", false, 3, "Focus GX-850", "850W Gold rated PSU, high quality", 850, "80+ Gold");
    PSU msiA650BN = new PSU(65.00, "MSI", false, 2, "MAG A650BN", "650W Bronze rated PSU, budget friendly", 650, "80+ Bronze");

    // UPS
    UPS cyberPower1500VA = new UPS(170.00, "CyberPower", false, 10, "CP1500PFCLCD", "1500VA Sine Wave UPS", 1500);
    UPS apcBackUPS600VA = new UPS(80.00, "APC", false, 5, "BE600M1", "600VA UPS for basic protection", 600);
    // --- End of Inventory ---


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
        System.out.println("Total Estimated Power: " + totalPowerConsumption + "W");
        System.out.println("Total Cost: $" + String.format("%.2f", totalCost));
        System.out.println("---------------------------------");
    }


    public void buildCustomPC() {
        final int TOTAL_STEPS = 8; // CPU, Mobo, GPU, RAM, Storage, Case, Cooling, PSU
        int currentStep = 0;

        // Determine starting step (if some components are already selected)
        if (selectedCPU == null) currentStep = 0;
        else if (selectedMotherboard == null) currentStep = 1;
        else if (selectedGPU == null) currentStep = 2;
        else if (selectedRAM == null) currentStep = 3;
        else if (selectedStorage == null) currentStep = 4;
        else if (selectedCase == null) currentStep = 5;
        else if (selectedCoolingSystem == null) currentStep = 6;
        else if (selectedPSU == null) currentStep = 7;
        else { // All main components selected, maybe just add UPS or finish
            System.out.println("All main components selected. Proceeding to UPS selection or finalization.");
            selectOptionalUPS();
            finalizeBuild();
            return;
        }


        while (currentStep < TOTAL_STEPS) {
            boolean stepCompleted = false;
            System.out.println("\n--- Step " + (currentStep + 1) + " of " + TOTAL_STEPS + " ---");
            System.out.println("Current Total Cost: $" + String.format("%.2f", totalCost) + " | Current Power: " + totalPowerConsumption + "W");

            switch (currentStep) {
                case 0: // CPU
                    if (selectedCPU != null) { // Undoing a previous selection
                        totalCost -= selectedCPU.getPrice();
                        totalPowerConsumption -= selectedCPU.getPowerConsumption();
                        selectedCPU = null;
                         if (selectedMotherboard != null && selectedMotherboard.getSocketCompatibility() != null) { // Invalidate motherboard if CPU changes
                            System.out.println("CPU changed, previous motherboard selection ("+selectedMotherboard.getName()+") might be incompatible and is removed.");
                            totalCost -= selectedMotherboard.getPrice();
                            totalPowerConsumption -= selectedMotherboard.getPowerConsumption();
                            selectedMotherboard = null;
                        }
                    }
                    CPU newCPU = selectCPU();
                    if (newCPU != null) {
                        selectedCPU = newCPU;
                        totalCost += selectedCPU.getPrice();
                        totalPowerConsumption += selectedCPU.getPowerConsumption();
                        stepCompleted = true;
                    }
                    break;
                case 1: // Motherboard
                    if (selectedMotherboard != null) {
                        totalCost -= selectedMotherboard.getPrice();
                        totalPowerConsumption -= selectedMotherboard.getPowerConsumption();
                        selectedMotherboard = null;
                    }
                    Motherboard newMobo = selectMotherboard();
                    if (newMobo != null) {
                        selectedMotherboard = newMobo;
                        totalCost += selectedMotherboard.getPrice();
                        totalPowerConsumption += selectedMotherboard.getPowerConsumption();
                        stepCompleted = true;
                    }
                    break;
                case 2: // GPU
                     if (selectedGPU != null) {
                        totalCost -= selectedGPU.getPrice();
                        totalPowerConsumption -= selectedGPU.getPowerConsumption();
                        selectedGPU = null;
                    }
                    GPU newGPU = selectGPU();
                    if (newGPU != null) {
                        selectedGPU = newGPU;
                        totalCost += selectedGPU.getPrice();
                        totalPowerConsumption += selectedGPU.getPowerConsumption();
                        stepCompleted = true;
                    }
                    break;
                case 3: // RAM
                    if (selectedRAM != null) {
                        totalCost -= selectedRAM.getPrice();
                        totalPowerConsumption -= selectedRAM.getPowerConsumption();
                        selectedRAM = null;
                    }
                    RAM newRAM = selectRAM();
                    if (newRAM != null) {
                        selectedRAM = newRAM;
                        totalCost += selectedRAM.getPrice();
                        totalPowerConsumption += selectedRAM.getPowerConsumption();
                        stepCompleted = true;
                    }
                    break;
                case 4: // Storage
                    if (selectedStorage != null) {
                        totalCost -= selectedStorage.getPrice();
                        totalPowerConsumption -= selectedStorage.getPowerConsumption();
                        selectedStorage = null;
                    }
                    Storage newStorage = selectStorage();
                    if (newStorage != null) {
                        selectedStorage = newStorage;
                        totalCost += selectedStorage.getPrice();
                        totalPowerConsumption += selectedStorage.getPowerConsumption();
                        stepCompleted = true;
                    }
                    break;
                case 5: // Case
                    if (selectedCase != null) {
                        totalCost -= selectedCase.getPrice();
                        totalPowerConsumption -= selectedCase.getPowerConsumption();
                        selectedCase = null;
                    }
                    Case newCase = selectCase();
                    if (newCase != null) {
                        selectedCase = newCase;
                        totalCost += selectedCase.getPrice();
                        totalPowerConsumption += selectedCase.getPowerConsumption();
                        stepCompleted = true;
                    }
                    break;
                case 6: // Cooling System
                    if (selectedCoolingSystem != null) {
                        totalCost -= selectedCoolingSystem.getPrice();
                        totalPowerConsumption -= selectedCoolingSystem.getPowerConsumption();
                        selectedCoolingSystem = null;
                    }
                    CoolingSystem newCooling = selectCoolingSystem();
                    if (newCooling != null) {
                        selectedCoolingSystem = newCooling;
                        totalCost += selectedCoolingSystem.getPrice();
                        totalPowerConsumption += selectedCoolingSystem.getPowerConsumption();
                        stepCompleted = true;
                    }
                    break;
                case 7: // PSU
                    if (selectedPSU != null) {
                        totalCost -= selectedPSU.getPrice();
                        // PSU's own consumption is usually negligible and part of its efficiency rating, not added to total.
                        // totalPowerConsumption -= selectedPSU.getPowerConsumption();
                        selectedPSU = null;
                    }
                    PSU newPSU = selectPSU();
                    if (newPSU != null) {
                        selectedPSU = newPSU;
                        totalCost += selectedPSU.getPrice();
                        // totalPowerConsumption += selectedPSU.getPowerConsumption();
                        stepCompleted = true;
                    }
                    break;
            }

            if (stepCompleted) {
                System.out.println( (currentStep == 0 ? selectedCPU.getName() :
                                     currentStep == 1 ? selectedMotherboard.getName() :
                                     currentStep == 2 ? selectedGPU.getName() :
                                     currentStep == 3 ? selectedRAM.getName() :
                                     currentStep == 4 ? selectedStorage.getName() :
                                     currentStep == 5 ? selectedCase.getName() :
                                     currentStep == 6 ? selectedCoolingSystem.getName() :
                                     selectedPSU.getName()) + " selected.");
                currentStep++;
            } else { // User chose to go back (input -1)
                if (currentStep > 0) {
                    currentStep--;
                    System.out.println("Going back to select " + getStepName(currentStep) + ".");
                    // Cost and power for the component of the step we are returning to is handled at the start of its case block.
                } else {
                    System.out.println("Cannot go back further. Returning to main menu.");
                    return; // Exit build process, back to main menu
                }
            }
        }

        if (currentStep == TOTAL_STEPS) {
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
        if (selectedUPS != null) { // If already selected and coming back
            totalCost -= selectedUPS.getPrice();
            totalPowerConsumption -= selectedUPS.getPowerConsumption();
            selectedUPS = null;
        }
        System.out.println("\n--- Optional: Select UPS ---");
        System.out.println("Would you like to add a UPS (Uninterruptible Power Supply)?");
        System.out.println("1. Yes");
        System.out.println("2. No, skip UPS");
        System.out.print("Choose an option: ");
        int choice = getIntInput();
        if (choice == 1) {
            UPS newUPS = selectUPS(); // This is the actual selection method
            if (newUPS != null) {
                selectedUPS = newUPS;
                totalCost += selectedUPS.getPrice();
                totalPowerConsumption += selectedUPS.getPowerConsumption(); // UPS itself consumes a little power
                System.out.println(selectedUPS.getName() + " added to build.");
            } else {
                System.out.println("No UPS selected or went back.");
            }
        } else {
            System.out.println("No UPS will be added.");
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
            System.out.println("No " + componentType + " options available that match current selections.");
            if(componentType.equals("Motherboard") && selectedCPU == null) {
                System.out.println("Please select a CPU first to see compatible motherboards.");
            }
            return null; // Should not happen if inventory is well-stocked, but good for safety
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
                scanner.next(); // Clear the invalid input
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
        return presentOptionsAndSelect("CPU", cpus, selectedCPU != null || selectedMotherboard != null); // Allow back if not first item
    }

    private Motherboard selectMotherboard() {
        if (selectedCPU == null) {
            System.out.println("Please select a CPU first to see compatible motherboards.");
            // Offer all motherboards if no CPU is selected, or make CPU selection mandatory first.
            // For now, let's assume CPU must be selected.
            return null; // Force user to go back or select CPU
        }
        List<Motherboard> motherboards = new ArrayList<>();
        // Filter motherboards based on selected CPU's socket type
        if (selectedCPU.getSocketType().equals("LGA1700")) {
            motherboards.add(z790_aorus_elite);
            // Add other LGA1700 motherboards here
        } else if (selectedCPU.getSocketType().equals("AM5")) {
            motherboards.add(b650m_ds3h);
            // Add other AM5 motherboards here
        } else if (selectedCPU.getSocketType().equals("AM4")) {
            motherboards.add(b550_tomahawk);
        }
        // Add all motherboards if no specific socket or if desired
        // motherboards.add(intelTier1); motherboards.add(intelTier2); ... etc.

        if (motherboards.isEmpty()){
            System.out.println("No motherboards found compatible with " + selectedCPU.getName() + " (" + selectedCPU.getSocketType() + "). Please check inventory or CPU selection.");
            return null;
        }
        return presentOptionsAndSelect("Motherboard", motherboards, true);
    }

    private GPU selectGPU() {
        List<GPU> gpus = new ArrayList<>();
        gpus.add(rtx4060);
        gpus.add(rx7800xt);
        gpus.add(rtx4070super);
        return presentOptionsAndSelect("GPU", gpus, true);
    }

    private RAM selectRAM() {
        List<RAM> rams = new ArrayList<>();
        // Could filter by DDR4/DDR5 based on motherboard if selectedMotherboard.getRamType() existed
        rams.add(ddr5_32gb_6000);
        rams.add(ddr4_16gb_3200);
        return presentOptionsAndSelect("RAM", rams, true);
    }

    private Storage selectStorage() {
        List<Storage> storages = new ArrayList<>();
        storages.add(nvme_1tb_sn770);
        storages.add(sata_2tb_mx500);
        storages.add(hdd_4tb_barracuda);
        return presentOptionsAndSelect("Storage", storages, true);
    }

    private Case selectCase() {
        List<Case> cases = new ArrayList<>();
        cases.add(fractalPopAir);
        cases.add(lianLiO11Dynamic);
        return presentOptionsAndSelect("Case", cases, true);
    }

    private CoolingSystem selectCoolingSystem() {
        List<CoolingSystem> coolers = new ArrayList<>();
        coolers.add(peerlessAssassin);
        coolers.add(ls720);
        coolers.add(noctuaNHU12S);
        return presentOptionsAndSelect("Cooling System", coolers, true);
    }

    private PSU selectPSU() {
        System.out.println("Recommended PSU Wattage based on selected components: ~" + (totalPowerConsumption + 100) + "W (includes ~100W headroom).");
        List<PSU> psus = new ArrayList<>();
        psus.add(msiA650BN); // 650W
        psus.add(corsairRM750e); // 750W
        psus.add(seasonicFocusGX850); // 850W
        // Filter PSUs based on totalPowerConsumption + headroom
        List<PSU> suitablePsus = new ArrayList<>();
        for (PSU psu : psus) {
            if (psu.getWattage() >= (totalPowerConsumption + 100)) { // Check if PSU wattage is sufficient
                suitablePsus.add(psu);
            }
        }
        if (suitablePsus.isEmpty()){
            System.out.println("Warning: No PSUs in stock meet the recommended wattage. Displaying all available.");
            return presentOptionsAndSelect("PSU", psus, true); // Show all if no suitable ones
        }

        return presentOptionsAndSelect("PSU (suitable options)", suitablePsus, true);
    }
    
    private UPS selectUPS() { // This is for the actual selection from list
        List<UPS> upsList = new ArrayList<>();
        upsList.add(apcBackUPS600VA);
        upsList.add(cyberPower1500VA);
        return presentOptionsAndSelect("UPS", upsList, true); // Allow back if called from optional step
    }
}
