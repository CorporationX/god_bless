package marketplace;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        productManager.addProduct(Category.FOOD, "Apple");
        productManager.addProduct(Category.FOOD, "Chocolate");
        productManager.addProduct(Category.ELECTRONICS, "MacBook");
        productManager.addProduct(Category.ELECTRONICS, "iPhone");
        productManager.addProduct(Category.CLOTHING, "T-shirt");
        productManager.addProduct(Category.CLOTHING, "Jeans");

        System.out.println("\nAll products grouped by category:");
        productManager.printAllProducts();

        System.out.println("\nProducts in the ELECTRONICS category:");
        for (Product product : productManager.findProductsByCategory(Category.ELECTRONICS)) {
            System.out.println("- " + product.getName());
        }

        productManager.removeProduct(Category.FOOD, "Apple");

        System.out.println("\nAll products grouped by category:");
        productManager.printAllProducts();
    }
}