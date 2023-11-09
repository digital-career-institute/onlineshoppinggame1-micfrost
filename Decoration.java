package D66_Exercises.DC_T_1_VirtualItems.micfro;

public class Decoration extends VirtualItem {

    private String theme;

    public Decoration(int itemID, String name, double price, int points, String theme) {
        super(itemID, name, price, points);
        this.theme = theme;
    }
}
