public class Peripheral {
    protected double weight;
    protected double[] dimensions;
    protected String IOtype;
    
    public Peripheral(double w, double[] d, String i) {

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

    public String getIO() {
        return IOtype;
    }


}