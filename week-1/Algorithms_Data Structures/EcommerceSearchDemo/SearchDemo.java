import java.util.*;

public class SearchDemo {

    public static Product linearSearch(Product[] products, String name) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String name) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int compare = products[mid].productName.compareToIgnoreCase(name);
            if (compare == 0) {
                return products[mid];
            } else if (compare < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] productList = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Footwear"),
            new Product(103, "Watch", "Accessories"),
            new Product(104, "Phone", "Electronics"),
            new Product(105, "Bag", "Travel")
        };

        Arrays.sort(productList, Comparator.comparing(p -> p.productName.toLowerCase()));

        Product result1 = linearSearch(productList, "Watch");
        System.out.println("Linear Search Result: " + (result1 != null ? result1 : "Not Found"));

        Product result2 = binarySearch(productList, "Watch");
        System.out.println("Binary Search Result: " + (result2 != null ? result2 : "Not Found"));
    }
}
