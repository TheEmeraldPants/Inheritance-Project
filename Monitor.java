public class Monitor extends Peripheral {
    protected String resolution;
    protected boolean hasStand;

    public Monitor(double p, String b, boolean rgb, int pCon, String desc, double w, double[] d, String i, String res, boolean stand) {
        super(p, b, rgb, pCon, desc, w, d, i);
        resolution = res;
        hasStand = stand;
        super.setDescription("A monitor is what you use to look at your computer's video output. \n They can have different resolutions, meaning higher or lower pixel quality, and some have stands");
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
}