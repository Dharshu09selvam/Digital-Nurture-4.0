
import java.util.HashMap;
import java.util.Scanner;

public class InventoryManager {
    HashMap<Integer, Product> inventory = new HashMap<>();
    public void addProduct(Product p) {
        inventory.put(p.productId, p);
        System.out.println("Product added.");
    }
    public void updateProduct(int id, int newQty, double newPrice) {
        Product p = inventory.get(id);
        if (p != null) {
            p.quantity = newQty;
            p.price = newPrice;
            System.out.println("Product updated.");
        } else {
            System.out.println("Product not found.");
        }
    }
    public void deleteProduct(int id) {
        if (inventory.remove(id) != null) {
            System.out.println("Product removed.");
        } else {
            System.out.println("Product not found.");
        }
    }
    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product p : inventory.values()) {
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Scanner sc = new Scanner(System.in);
        manager.addProduct(new Product(1, "Mouse", 50, 299.0));
        manager.addProduct(new Product(2, "Keyboard", 30, 499.0));

        System.out.println("\nCurrent Inventory:");
        manager.displayInventory();

        System.out.println("\nUpdating Product ID 1...");
        manager.updateProduct(1, 60, 279.0);

        System.out.println("\nInventory after update:");
        manager.displayInventory();

        System.out.println("\nDeleting Product ID 2...");
        manager.deleteProduct(2);

        System.out.println("\nInventory after deletion:");
        manager.displayInventory();
    }
}
