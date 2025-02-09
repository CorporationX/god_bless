package school.faang.bjs22_56885;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct(Category.FOOD, "Apple");
        productManager.addProduct(Category.FOOD, "Banana");
        productManager.addProduct(Category.CLOTHING, "Jacket");
        productManager.addProduct(Category.CLOTHING, "T-shirt");
        productManager.removeProduct(Category.FOOD, "Apple");
        productManager.findProductsByCategory(Category.OTHER);
        productManager.groupProductsByCategory();
        productManager.printAllProducts();
    }
}
