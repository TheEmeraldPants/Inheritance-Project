public class Motherboard extends Component {
    private String size;
    private int RAMslots;
    private String cpuType;
    private String Io;

    public Motherboard(double price, String brand, boolean hasRGB, int powerConsumption, String description, String size, int RAMslots, String cpuType, String Io) {
        super(price, brand, hasRGB, powerConsumption, description);
        this.size = size;
        this.RAMslots = RAMslots;
        this.cpuType = cpuType;
        this.Io = Io;
    }

    public String getSize() {
        return size;
    }

    public int getRAMslots() {
        return RAMslots;
    }

    public String getCpuType() {
        return cpuType;
    }

    public String getIo() {
        return Io;
    }
    
}
