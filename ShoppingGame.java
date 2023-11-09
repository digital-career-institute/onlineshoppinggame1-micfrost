package D66_Exercises.DC_T_1_VirtualItems.micfro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingGame {

    public static void main(String[] args) {

        ArrayList<VirtualItem> virtualItemList = new ArrayList<>();

        virtualItemList.add(new PowerUp(1001, "Double Points PowerUp", 10, 50, "Double Points"));
        virtualItemList.add(new Decoration(2002, "Fantasy Worlds Decos", 20, 100, "Space"));

        int playerNumberOfPoints = 100;
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Virtual Shopping Game");
            System.out.println("1. Display Items");
            System.out.println("2. Shop for Items");
            System.out.println("3. Display Shopping Cart");
            System.out.println("4. Display Total Points");
            System.out.println("5. Quit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayItems(virtualItemList);
                    break;
                case 2:
                    shopForItems(virtualItemList, playerNumberOfPoints);
                    break;
                case 3:
                    displayShoppingCart(new ArrayList<>(), playerNumberOfPoints); // Provide an empty cart for now
                    break;
                case 4:
                    displayTotalPoints(playerNumberOfPoints);
                    break;
                case 5:
                    System.out.println("Thanks for playing! Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private static void displayItems(ArrayList<VirtualItem> virtualItemList) {
        System.out.println("Available Items:");
        for (VirtualItem item : virtualItemList) {
            System.out.println(item);
        }
    }

    private static int shopForItems(ArrayList<VirtualItem> virtualItemList, int playerNumberOfPoints) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<VirtualItem> shoppingCart = new ArrayList<>();

        displayItems(virtualItemList);
        System.out.println("Your Points: " + playerNumberOfPoints);

        System.out.print("Enter the item ID you want to purchase (0 to exit): ");
        int itemID = scanner.nextInt();

        while (itemID != 0) {
            VirtualItem selectedItem = findItem(virtualItemList, itemID);

            if (selectedItem != null && playerNumberOfPoints >= selectedItem.getPrice()) {
                playerNumberOfPoints -= selectedItem.getPrice();
                shoppingCart.add(selectedItem);
                System.out.println("You purchased: " + selectedItem.getName());
            } else if (selectedItem == null) {
                System.out.println("Invalid item ID. Please try again.");
            } else {
                System.out.println("Not enough points to purchase " + selectedItem.getName());
            }

            displayItems(virtualItemList);
            System.out.println("Your Points: " + playerNumberOfPoints);

            System.out.print("Enter the item ID you want to purchase (0 to exit): ");
            itemID = scanner.nextInt();
        }

        displayShoppingCart(shoppingCart, playerNumberOfPoints);
        return playerNumberOfPoints;
    }

    private static VirtualItem findItem(ArrayList<VirtualItem> itemList, int itemID) {
        for (VirtualItem item : itemList) {
            if (item.getItemID() == itemID) {
                return item;
            }
        }
        return null;
    }

    private static void displayShoppingCart(ArrayList<VirtualItem> cartItems, int remainingPoints) {
        if (cartItems.isEmpty()) {
            System.out.println("Shopping Cart is empty.");
        } else {
            System.out.println("Shopping Cart:");
            for (VirtualItem item : cartItems) {
                System.out.println(item.getName() + " - Price: $" + item.getPrice());
            }
            System.out.println("Remaining Points: " + remainingPoints);
        }
    }

    private static void displayTotalPoints(int playerNumberOfPoints) {
        System.out.println("Your number of points: " + playerNumberOfPoints);
    }

}

