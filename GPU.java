public class GPU {
    private double price;
    private String brand;
    private boolean hasRGB;
    private int powerConsumption;
    private String description;

    private int VRAM;
    private int cores;
    private int speed;       // in MHz or GHz
    private String type;     // e.g., "GDDR6", "RTX", etc.
    private String size;     // e.g., "Dual-slot", "Triple-slot"
    private boolean canOverclock;

    public GPU(double price, String brand, boolean hasRGB, int powerConsumption,
               String description, String size, boolean canOverclock,
               int VRAM, int cores, int speed, String type) {
        this.price = price;
        this.brand = brand;
        this.hasRGB = hasRGB;
        this.powerConsumption = powerConsumption;
        this.description = description;
        this.size = size;
        this.canOverclock = canOverclock;
        this.VRAM = VRAM;
        this.cores = cores;
        this.speed = speed;
        this.type = type;
    }

    // Optional: Getters
    public double getPrice() { return price; }
    public String getBrand() { return brand; }
    public boolean hasRGB() { return hasRGB; }
    public int getPowerConsumption() { return powerConsumption; }
    public String getDescription() { return description; }
    public String getSize() { return size; }
    public boolean canOverclock() { return canOverclock; }
    public int getVRAM() { return VRAM; }
    public int getCores() { return cores; }
    public int getSpeed() { return speed; }
    public String getType() { return type; }
}
