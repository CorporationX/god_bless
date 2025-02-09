package school.faang;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        manager.addProduct(Category.CLOTHING, "Jeans");
        manager.addProduct(Category.CLOTHING, "T-Shirt");
        manager.addProduct(Category.ELECTRONICS, "Laptop");
        manager.addProduct(Category.ELECTRONICS, "AirPods");
        manager.addProduct(Category.FOOD, "Apple");
        manager.addProduct(Category.FOOD, "Burger");
        manager.addProduct(Category.OTHER, "Table");
        manager.addProduct(Category.OTHER, "Soap");

        manager.groupProductsByCategory();

        System.out.println("All products:");
        manager.printAllProducts();

        manager.removeProduct(Category.ELECTRONICS, "Laptop");
        manager.groupProductsByCategory();

        System.out.println("All products after Laptop removal");
        manager.printAllProducts();
    }
}
