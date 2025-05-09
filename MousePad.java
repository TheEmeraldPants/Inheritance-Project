
public class MousePad extends Peripheral {
    protected String surfaceType;

    public MousePad(double p, String b, boolean rgb, int pCon, String desc, double w, double[] d, String i, String sType){
        super(p, b, rgb, pCon, desc, w, d, i);
        surfaceType = sType;
       // super.setDescription("A mousepad is used as a surface for your mouse to move on. \nThey can have different surface types for different experiences.");
    }

    public String getSurface() {
        return surfaceType;
    }

    public void setSurface(String sType) {
        surfaceType = sType;
    }
}