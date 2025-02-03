package school.faang;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct(Product.Category.FOOD, "Apple");
        productManager.addProduct(Product.Category.FOOD, "Banana");
        productManager.addProduct(Product.Category.CLOTHING, "Jacket");
        productManager.addProduct(Product.Category.CLOTHING, "T-shirt");

        productManager.removeProduct(Product.Category.CLOTHING, "Jacket");
        productManager.removeProduct(Product.Category.CLOTHING, "Jacket");
        productManager.printAllProducts();
    }
}
