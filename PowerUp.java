package D66_Exercises.DC_T_1_VirtualItems.micfro;

public class PowerUp extends VirtualItem {

    private String effect;

    public PowerUp(int itemID, String name, double price, int points, String effect) {
        super(itemID, name, price, points);
        this.effect = effect;


    }
}



