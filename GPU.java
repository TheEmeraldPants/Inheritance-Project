public class GPU extends Component{

    private int VRAM;
    private int cores;
    private int speed;
    private String type;
    private String brand;
    private boolean hasRGB;
    private int powerConsumption;
    private String description;
    public GPU(double price, String brand, boolean hasRGB, int powerConsumption, String description, int VRAM, int cores, int speed, String type) {
        super(price, brand, hasRGB, powerConsumption, description);
        this.VRAM = VRAM;
        this.cores = cores;
        this.speed = speed;
        this.type = type;
    }
    public int getVRAM() {
        return VRAM;
    }
    public int getCores() {
        return cores;
    }
    public int getSpeed() {
        return speed;
    }
    public String getType() {
        return type;
    }
    public Boolean isCompatible(Motherboard motherboard) {
        return motherboard.getDDRVersionSupported() == VRAM;
    }
}