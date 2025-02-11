package school.faang.amazon_store;

public class Main {

    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct(Category.CLOTHING, "blouse");
        productManager.addProduct(Category.CLOTHING, "blouse");
        productManager.addProduct(Category.CLOTHING, "blouse");
        productManager.addProduct(Category.FOOD, "apple");
        productManager.addProduct(Category.ELECTRONICS, "TV");

        productManager.printAllProducts();
        productManager.removeProduct(Category.CLOTHING, "blouse");
        productManager.printAllProducts();
    }
}
