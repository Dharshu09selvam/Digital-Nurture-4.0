public class SortOrders {

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; 
        }
    }

/*QUICK SORT */   
 public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }
    public static void display(Order[] orders, String msg) {
        System.out.println("\n" + msg);
        for (Order o : orders) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order(101, "Alice", 1500.50),
            new Order(102, "Bob", 499.99),
            new Order(103, "Charlie", 2200.75),
            new Order(104, "Dharshini", 999.00)
        };

        Order[] bubbleSorted = orders.clone();
        Order[] quickSorted = orders.clone();

        bubbleSort(bubbleSorted);
        display(bubbleSorted, "Orders Sorted by Bubble Sort:");

        quickSort(quickSorted, 0, quickSorted.length - 1);
        display(quickSorted, "Orders Sorted by Quick Sort:");
    }
}
