package school.faang.secondtask;

public class Main {
    public static void main(String[] args) throws Exception {
        ProductManager productManager = new ProductManager();
        productManager.addProduct(Category.FOOD, "Meat");
        productManager.addProduct(Category.ELECTRONICS, "Phone");
        productManager.addProduct(Category.CLOTHING, "Pants");
        productManager.addProduct(Category.FOOD, "Milk");
        productManager.addProduct(Category.OTHER, "Smth");

        productManager.groupProductsByCategory();

        productManager.printAllProducts();
    }
}
