

public class CPU extends Component {
    private String type;
    private int cores;
    private boolean canOverclock;

    public CPU(double price, String brand, boolean hasRGB, int powerConsumption, String description, String type, int cores, boolean canOverclock, Boolean hasIGPU) {
        super(price, brand, hasRGB, powerConsumption, description);
        this.type = type;
        this.cores = cores;
        this.canOverclock = canOverclock;
    }

    public String getType() {
        return type;
    }

    public int getCores() {
        return cores;
    }

    public boolean getCanOverclock() {
        return canOverclock;
    }

    public boolean isCompatible(Motherboard motherboard) {
        return motherboard.getCpuType().equals(type);
    }
}