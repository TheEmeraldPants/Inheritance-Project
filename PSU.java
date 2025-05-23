

public class PSU extends Component{

    private int power;
    private String brand;
    private boolean hasRGB;
    private int powerConsumption;
    private String description;
    public PSU(double price, String brand, boolean hasRGB, int powerConsumption, String name, String description, int power) {
        super(price, brand, hasRGB, powerConsumption, name, description);
        this.power = power;
    }
    public int getPower() {
        return power;
    }
    
    public String toString() {
        return "PSU: " + brand + " " + power + "W";
    }
}
