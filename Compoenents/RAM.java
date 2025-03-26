package Compoenents;
public class RAM extends Component {
    private int DDRVersion;
    private int capacity;
    private int speed;
    private String type;
    private String brand;
    private boolean hasRGB;
    private int powerConsumption;
    private String description;
    public RAM(double price, String brand, boolean hasRGB, int powerConsumption, String description, int DDRVersion, int capacity, int speed, String type) {
        super(price, brand, hasRGB, powerConsumption, description);
        this.DDRVersion = DDRVersion;
        this.capacity = capacity;
        this.speed = speed;
        this.type = type;
    }
    public int getDDRVersion() {
        return DDRVersion;
    }
    public int getCapacity() {
        return capacity;
    }
    public int getSpeed() {
        return speed;
    }
    public String getType() {
        return type;
    }
    public Boolean isCompatible(Motherboard motherboard) {
        return motherboard.getDDRVersionSupported() == DDRVersion;
    }
    
}
