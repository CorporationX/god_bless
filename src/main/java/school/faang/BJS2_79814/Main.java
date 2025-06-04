package school.faang.BJS2_79814;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        productManager.addProduct(Category.FOOD, "Apple");
        productManager.addProduct(Category.FOOD, "Bread");
        productManager.addProduct(Category.ELECTRONICS, "Laptop");
        productManager.addProduct(Category.ELECTRONICS, "Smartphone");
        productManager.addProduct(Category.ELECTRONICS, "Smartphone2");


        productManager.findProductsByCategory(Category.ELECTRONICS).forEach(System.out::println);
        productManager.removeProduct(Category.ELECTRONICS, "Smartphone2");

        productManager.printAllProducts();
    }
}
