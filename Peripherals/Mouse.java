package Peripherals;
public class Mouse extends Peripheral {
    protected int DPI; 
    protected int extraButtons;

    public Mouse(double p, String b, boolean rgb, int pCon, String desc, double w, double[] d, String i, int dpi, int exBut) {
        super(p, b, rgb, pCon, desc, w, d, i);
        DPI = dpi;
        extraButtons = exBut;
    }

    public int getDPI() {
        return DPI;
    }

    public void setDPI(int dpi) {
        DPI = dpi;
    }

    public int getExtraButtons() {
        return extraButtons;
    }

    public void setExtraButtons(int exBut) {
        extraButtons = exBut;
    }
}