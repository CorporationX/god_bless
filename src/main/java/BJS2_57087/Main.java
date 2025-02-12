package BJS2_57087;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        productManager.addProduct(Category.FOOD, "Apple");
        productManager.addProduct(Category.FOOD, "Bread");
        productManager.addProduct(Category.ELECTRONICS, "Laptop");
        productManager.addProduct(Category.FOOD, "Laptop");
        productManager.addProduct(Category.ELECTRONICS, "Laptop");
        productManager.addProduct(Category.ELECTRONICS, "Smartphone");

        productManager.printAllProducts();
        System.out.println("----------------------------");

        System.out.println(productManager.findProductsByCategory(Category.FOOD));
        System.out.println("----------------------------");

        productManager.removeProduct(Category.FOOD, "Apple");
        productManager.printAllProducts();
        System.out.println("----------------------------");

        productManager.groupProductsByCategory();
        productManager.printAllProducts();
    }
}
