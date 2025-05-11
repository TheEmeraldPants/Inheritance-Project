public class Monitor extends Peripheral {
    protected String resolution;
    protected boolean hasStand;

    public Monitor(double price, String brand, boolean rgb, int pCon, String name, String desc, double weight, double[] dimensions, String iotype, String res, boolean stand) {
        super(price, brand, rgb, pCon, name, desc, weight, dimensions, iotype);
        resolution = res;
        hasStand = stand;
        //super.setDescription("A monitor is what you use to look at your computer's video output. \n They can have different resolutions, meaning higher or lower pixel quality, and some have stands");
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String res) {
        resolution = res;
    }

    public boolean getStand() {
        return hasStand;
    }

    public void setStand(boolean stand) {
        hasStand = stand;
    }

    public String toString() {
        return super.toString() + "\n" +
               "Resolution: " + resolution + "\n" +
               "Has Stand: " + (hasStand ? "Yes" : "No");
    }
}