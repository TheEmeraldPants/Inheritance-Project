
public class Mouse extends Peripheral {
    protected int DPI; 
    protected int extraButtons;

    public Mouse(double price, String brand, boolean rgb, int pCon, String desc, double weight, double[] dimensions, String ioPort, int dpi, int extraButtons) {
        super(price, brand, rgb, pCon, desc, weight, dimensions, ioPort);
        DPI = dpi;
        this.extraButtons = extraButtons;
      //  super.setDescription("A mouse is used to move your cursor. \n They have different DPIs, which represents how sensitive they are. Some also have extra mappable buttons.");
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