import java.util.Arrays;
import java.util.Comparator;

public class LibrarySearch {

    public static Book linearSearch(Book[] books, String targetTitle) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(targetTitle)) {
                return b;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String targetTitle) {
        int low = 0, high = books.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int compare = books[mid].title.compareToIgnoreCase(targetTitle);
            if (compare == 0) return books[mid];
            else if (compare < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "The Alchemist", "Paulo Coelho"),
            new Book(2, "Zero to One", "Peter Thiel"),
            new Book(3, "Clean Code", "Robert C. Martin"),
            new Book(4, "Atomic Habits", "James Clear"),
            new Book(5, "Deep Work", "Cal Newport")
        };

        Book[] sortedBooks = books.clone();
        Arrays.sort(sortedBooks, Comparator.comparing(b -> b.title.toLowerCase()));

        System.out.println("Linear Search for 'Clean Code':");
        Book found1 = linearSearch(books, "Clean Code");
        System.out.println(found1 != null ? found1 : "Not found");

        System.out.println("\nBinary Search for 'Clean Code':");
        Book found2 = binarySearch(sortedBooks, "Clean Code");
        System.out.println(found2 != null ? found2 : "Not found");
    }
}
