public class Keyboard extends Peripheral {
    private String switchType;
    private int percentage;
    private boolean hasNumpad;

    public Keyboard(double price, String brand, boolean hasRGB, int powerConsumption, String name, String description, double weight, double[] dimensions, String IOtype, String switchType, int percentage, boolean hasNumpad) {
        super(price, brand, hasRGB, powerConsumption, name, description, weight, dimensions, IOtype);
        this.switchType = switchType;
        this.percentage = percentage;
        this.hasNumpad = hasNumpad;
    }

    public String getSwitchType() {
        return switchType;
    }

    public void setSwitchType(String switchType) {
        this.switchType = switchType;
    }

    public int getPercentage() {
        return percentage;
    }
    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
    public boolean hasNumpad() {
        return hasNumpad;
    }
    public void setNumpad(boolean hasNumpad) {
        this.hasNumpad = hasNumpad;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Switch Type: " + switchType + "\n" +
               "Percentage: " + percentage + "%\n" +
               "Has Numpad: " + (hasNumpad ? "Yes" : "No");
    }
}
