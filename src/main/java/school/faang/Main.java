package school.faang;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct(Category.FOOD, "Apple");
        productManager.addProduct(Category.FOOD, "Banana");
        productManager.addProduct(Category.CLOTHING, "Jacket");
        productManager.addProduct(Category.CLOTHING, "T-shirt");

        productManager.removeProduct(null, null);
        productManager.removeProduct(Category.CLOTHING, "Jacket");
        productManager.groupProductsByCategory();
        productManager.printAllProducts();
        System.out.println(productManager.findProductsByCategory(Category.ELECTRONICS));
    }
}
