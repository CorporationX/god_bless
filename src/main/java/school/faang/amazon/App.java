package school.faang.amazon;


public class App {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        manager.addProduct(Category.FOOD, "Apple");
        manager.addProduct(Category.FOOD, "Banana");
        manager.addProduct(Category.ELECTRONICS, "Laptop");
        manager.addProduct(Category.CLOTHING, "T-Shirt");
        manager.addProduct(Category.CLOTHING, "Cap");

        System.out.println("All products:");
        manager.printAllProducts();

        manager.removeProduct(Category.FOOD, "Apple");

        System.out.println("\nProducts after removal:");
        manager.printAllProducts();

        System.out.println("\nProducts in Food category:");
        manager.findProductsByCategory(Category.FOOD);
    }
}