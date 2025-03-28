public class Headset extends Peripheral {
    protected boolean noiseCancelling;
    protected String soundProfile; 

    public Headset(double p, String b, boolean rgb, int pCon, String desc, double w, double[] d, String i, boolean nCan, String sProf) {
        super(p, b, rgb, pCon, desc, w, d, i);
        noiseCancelling = nCan;
        soundProfile = sProf;
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
}