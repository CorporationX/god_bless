package school.faang.amazon;

public class Main {
    public static void main(String[] args) {

        ProductManager productManager = new ProductManager();

        productManager.addProduct(Category.FOOD, "Apple");
        productManager.addProduct(Category.FOOD, "Pear");
        productManager.addProduct(Category.FOOD, "Plum");
        productManager.addProduct(Category.ELECTRONICS, "TV");
        productManager.addProduct(Category.ELECTRONICS, "Laptop");
        productManager.addProduct(Category.ELECTRONICS, "Smartphone");
        productManager.addProduct(Category.ELECTRONICS, "Tablet");
        productManager.addProduct(Category.CLOTHING, "Dress");
        productManager.addProduct(Category.CLOTHING, "Trousers");
        productManager.addProduct(Category.CLOTHING, "Underpants");
        productManager.addProduct(Category.OTHER, "Fork");
        productManager.addProduct(Category.OTHER, "Spoon");

        productManager.printAllProducts();

        productManager.removeProduct(Category.CLOTHING, "Trousers");
        productManager.removeProduct(Category.CLOTHING, "Fok");
        productManager.groupProductsByCategory();
        productManager.printAllProducts();
        productManager.findProductsByCategory(Category.CLOTHING).forEach(System.out::println);
    }
}
