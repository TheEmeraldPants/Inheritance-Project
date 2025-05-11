public class Headset extends Peripheral {
    protected boolean noiseCancelling;
    protected String soundProfile; 

    public Headset(double price, String brand, boolean rgb, int pCon, String name, String desc, double weight, double[] dimensions, String iotype, boolean nCan, String sProf) {
        super(price, brand, rgb, pCon, name, desc, weight, dimensions, iotype);
        noiseCancelling = nCan;
        soundProfile = sProf;
        //super.setDescription("A headset is used to listen to computer sounds privately, or to block outside noises. \n Headsets can have different sound profiles, meaning they have more bass, mids, or top-end.");
    }

    public boolean getNoiseCancelling() {
        return noiseCancelling;
    }

    public void setNoiseCancelling(boolean nCan) {
        noiseCancelling = nCan;
    }

    public String getSoundProfile() {
        return soundProfile; 
    }

    public void setSoundProfile(String sProf) {
        soundProfile = sProf;
    }

    public String toString() {
        return super.toString() + "\n" +
               "Noise Cancelling: " + (noiseCancelling ? "Yes" : "No") + "\n" +
               "Sound Profile: " + soundProfile;
    }
}