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

}