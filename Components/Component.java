package Compoenents;
// Each Component is a Class
// Component
// price
// brand
// hasRGB
// powerConsumption
// description
// Cases RGB
//RamType
// style 
// dimensions
// ports 
// Motherboards
// size 
// RAMslots
// cpuType
// Io 
// CPUs
// type 
// cores 
// canOverclock
// GPUs
// size 
// canOverclock
// RAM
// memory
//int DDRVersion
// capacity
// Storage
// storage 
// isSSD


// PSU
// wattage 
// powerSupplyRating
// UPS
// capacity
// Cooling systems RGB
// type


public class Component {
    protected double price;
    protected String brand;
    protected boolean hasRGB;
    protected int powerConsumption;
    protected String description;
    

    public Component(double price , String brand , boolean hasRGB , int powerConsumption, String description){
        this.price = price;
        this.brand = brand;
        this.hasRGB = hasRGB;
        this.powerConsumption = powerConsumption;
        this.description = description;   
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String desc) {
        description = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double p) {
        price = p;
    }

    public boolean getRGB() {
        return hasRGB;
    }

    public void setRGB(boolean rgb) {
        hasRGB = rgb;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    } 

    public void setPowerConsumption(int pCon) {
        powerConsumption = pCon;
    }
}
