import java.util.Arrays;

// 1. PRODUCT CLASS DEFINITION
class Product implements Comparable<Product> {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }

    // Required to sort the products array by ID for Binary Search
    @Override
    public int compareTo(Product other) {
        return Integer.compare(this.productId, other.productId);
    }

    @Override
    public String toString() {
        return "Product[ID=" + productId + ", Name=" + productName + ", Category=" + category + "]";
    }
}

// 2. MAIN EXECUTION & SEARCH ALGORITHMS
public class Main {

    // LINEAR SEARCH: O(N) Time Complexity
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.getProductId() == targetId) {
                return product; // Found item
            }
        }
        return null; // Not found
    }

    // BINARY SEARCH: O(log N) Time Complexity
    public static Product binarySearch(Product[] sortedProducts, int targetId) {
        int low = 0;
        int high = sortedProducts.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midId = sortedProducts[mid].getProductId();

            if (midId == targetId) {
                return sortedProducts[mid]; // Found item
            } else if (midId < targetId) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }
        return null; // Not found
    }

    // TESTING THE SCRIPT
    public static void main(String[] args) {
        // Create an unsorted array of products
        Product[] inventory = {
            new Product(105, "Wireless Mouse", "Electronics"),
            new Product(101, "Mechanical Keyboard", "Electronics"),
            new Product(108, "Running Shoes", "Apparel"),
            new Product(103, "Coffee Mug", "Kitchen")
        };

        int targetId = 108;
        System.out.println("Searching for Product ID: " + targetId + "\n");

        // --- Linear Search Test ---
        System.out.println("=== Running Linear Search (Unsorted Array) ===");
        Product match1 = linearSearch(inventory, targetId);
        System.out.println("Found: " + match1);

        // --- Binary Search Test ---
        System.out.println("\n=== Running Binary Search (Sorting Array First) ===");
        // Critical Step: Binary Search breaks completely if data isn't sorted!
        Arrays.sort(inventory); 
        
        Product match2 = binarySearch(inventory, targetId);
        System.out.println("Found: " + match2);
    }
}
