package D66_Exercises.DC_T_1_VirtualItems.micfro;

public class VirtualItem {

  private   int itemID;
//            (unique identifier for each virtual item).
private  String name;
//            (the name of the item).
private   double price;
//            (the virtual price of the item).
private   int points;
//            (the points that can be earned by purchasing the item).


    public VirtualItem(int itemID, String name, double price, int points) {
        this.itemID = itemID;
        this.name = name;
        this.price = price;
        this.points = points;
    }

    @Override
    public String toString() {
        return String.format("VirtualItem: \tID: %d, \tName: %s, \tPrice: %.2f,  \tPoints: %d", itemID, name, price, points);
    }


    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
