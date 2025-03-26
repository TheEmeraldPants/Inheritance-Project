package Compoenents;
public class UPS extends Component{

    private int power;
    private String brand;
    private boolean hasRGB;
    private int powerConsumption;
    private String description;
    public UPS(double price, String brand, boolean hasRGB, int powerConsumption, String description, int power) {
        super(price, brand, hasRGB, powerConsumption, description);
        this.power = power;
    }
    public int getPower() {
        return power;
    }
    
    public String toString() {
        return "UPS: " + brand + " " + power + "W";
    }
}