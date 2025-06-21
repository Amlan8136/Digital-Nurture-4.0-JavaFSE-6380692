import java.util.*;

class Product {
    int productID;
    String productName, category;

    Product(int productID, String productName, String category) {
        this.productID = productID;
        this.productName = productName;
        this.category = category;
    }

    public String toString() {
        return "Product[productID = " + productID + ", productName = " + productName + ", Category = " + category + "]";
    }
}

public class ProductSearch {

    static Product linearSearch(Product[] arr, int target) {
        for (Product p : arr) if (p.productID == target) return p;
        return null;
    }

    static Product binarySearch(Product[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m].productID == target) return arr[m];
            else if (arr[m].productID < target) l = m + 1;
            else r = m - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product[] products = {
            new Product(1159, "Laptop", "Electronics"),
            new Product(2853, "T-shirt", "Apparel"),
            new Product(4096, "Headphones", "Electronics"),
            new Product(2533, "Book", "Books"),
            new Product(3846, "Shoes", "Footwear")
        };

        System.out.print("Enter Product's productID to search: ");
        int productID = sc.nextInt();

        Product result1 = linearSearch(products, productID);
        System.out.println("Linear Search: " + (result1 != null ? result1 : "Invalid productID , Enter a valid productID."));

        Arrays.sort(products, (a, b) -> a.productID - b.productID);
        Product result2 = binarySearch(products, productID);
        System.out.println("Binary Search: " + (result2 != null ? result2 : "Invalid productID , Enter a valid productID."));

        sc.close();
    }
}
