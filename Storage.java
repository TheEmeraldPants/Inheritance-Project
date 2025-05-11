

public class Storage extends Component{
    
    private int capacity;
    private int speed;
    private String type;
    private String brand;
    private boolean hasRGB;
    private int powerConsumption;
    private String description;
    public Storage(double price, String brand, boolean hasRGB, int powerConsumption, String name, String description, int capacity, int speed, String type) {
        super(price, brand, hasRGB, powerConsumption, name, description);
        this.capacity = capacity;
        this.speed = speed;
        this.type = type;
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

}
