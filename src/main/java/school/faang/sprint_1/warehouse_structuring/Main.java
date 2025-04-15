package school.faang.sprint_1.warehouse_structuring;

public class Main {
    public static void main(String[] args) throws Exception {
        ProductManager productManager = new ProductManager();
        productManager.addProduct(Category.FOOD, "Meat");
        productManager.addProduct(Category.ELECTRONICS, "Phone");
        productManager.addProduct(Category.CLOTHING, "Pants");
        productManager.addProduct(Category.FOOD, "Milk");
        productManager.addProduct(Category.OTHER, "Smth");

        productManager.findProductsByCategory(Category.ELECTRONICS);

        productManager.groupProductsByCategory();

        productManager.printAllProducts();

        productManager.removeProduct(Category.CLOTHING, "Pants");
        productManager.printAllProducts();
    }
}
