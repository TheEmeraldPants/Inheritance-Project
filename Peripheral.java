public class Peripheral extends Component{
    protected double weight;
    protected double[] dimensions;
    protected String IOtype;
    
    public Peripheral(double price, String brand, boolean rgb, int pCon, String name, String desc, double weight, double[] dimensions, String IOType) {
        super(price, brand, rgb, pCon, name, desc);
        this.weight = weight;
        this.dimensions = dimensions;
        IOtype = IOType;
        //Description="A peripheral is typically something you plug into your computer to interact with it.";
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

    public String toString() {
        return super.toString() + "\n" +
               "Weight: " + weight + " kg\n" +
               "Dimensions: " + dimensions[0] + " x " + dimensions[1] + " x " + dimensions[2] + " cm\n" +
               "IO Type: " + IOtype;
    }
    //public boolean freePort(Case c) {
        //String[] ports = c.getPorts();
        //for (String port : ports) {
          //  if (IOtype.equals(port)) {
            //    port = "x";
              //  c.setPorts(ports);
                //return true;
            //}
        //}
        
        //return false;
    //}

}