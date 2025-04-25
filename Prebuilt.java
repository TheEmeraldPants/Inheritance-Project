public class Prebuilt {
    private String name;
    private double price;
    private String brand;
    private boolean hasRGB;
    private int powerConsumption;
    private String description;
    private int powerSupplyWattage;

    public Prebuilt(String name, double price, String brand, boolean hasRGB, int powerConsumption, String description, int powerSupplyWattage) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.hasRGB = hasRGB;
        this.powerConsumption = powerConsumption;
        this.description = description;
        this.powerSupplyWattage = powerSupplyWattage;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public boolean hasRGB() {
        return hasRGB;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public String getDescription() {
        return description;
    }

    public int getPowerSupplyWattage() {
        return powerSupplyWattage;
    }

    public String toString() {
        return name + " ($" + price + ")\n" +
               "Brand: " + brand + "\n" +
               "RGB: " + (hasRGB ? "Yes" : "No") + "\n" +
               "Estimated Power Consumption: " + powerConsumption + "W\n" +
               "Recommended PSU: " + powerSupplyWattage + "W\n" +
               "Description: " + description;
    }
}
