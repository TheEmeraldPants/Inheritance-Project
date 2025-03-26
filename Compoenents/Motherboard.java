package Compoenents;
public class Motherboard extends Component {
    private String size;
    private int RAMslots;
    private String cpuType;
    private String Io;
    private int CPUArchetecture;// 1700  Supports 12th, 13th, and 14th Gen Intel CPUs.
//1200 Supports 10th and 11th Gen Intel CPUs.
//5 Supports Ryzen 7000 Series CPUs.
    public Motherboard(double price, String brand, boolean hasRGB, int powerConsumption, String description, String size, int RAMslots, int CPUArchetecture ,String cpuType, String Io) {
        super(price, brand, hasRGB, powerConsumption, description);
        this.size = size;
        this.RAMslots = RAMslots;
        this.cpuType = cpuType;
        this.Io = Io;
        this.CPUArchetecture = CPUArchetecture;

        
    }
    
    public int getDDRVersionSupported() {
        return CPUArchetecture;
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
    
    //returying push
}
