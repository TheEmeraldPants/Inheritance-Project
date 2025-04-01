package Peripherals;
import Compoenents.Component;

public class Peripheral extends Component{
    protected double weight;
    protected double[] dimensions;
    protected String IOtype;
    
    public Peripheral(double p, String b, boolean rgb, int pCon, String desc, double w, double[] d, String i) {
        super(p, b, rgb, pCon, desc);
        weight = w;
        dimensions = d;
        IOtype = i;
        super.setDescription("A peripheral is typically something you plug into your computer to interact with it.");
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double w) {
        weight = w;
    }

    public double[] getDimensions() {
        return dimensions;
    }

    public void setDimensions(double[] d) {
        dimensions = d;
    }

    public String getIO() {
        return IOtype;
    }

    public void setIO(String i) {
        IOtype = i;
    }

    public boolean freePort(Case c) {
        String[] ports = c.getPorts();
        for (String port : ports) {
            if (IOtype.equals(port)) {
                port = "x";
                c.setPorts(ports);
                return true;
            }
        }
        
        return false;
    }

}