package school.faang.task_57030;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        productManager.addProduct(Category.FOOD, "Apple");
        productManager.addProduct(Category.FOOD, "Apple");
        productManager.addProduct(Category.ELECTRONICS, "Washing machine");
        productManager.addProduct(Category.ELECTRONICS, "Heater");
        productManager.addProduct(Category.OTHER, "VW golf");
        productManager.addProduct(Category.CLOTHING, "T-shirt");

        productManager.printAllProducts();

        productManager.findProductsByCategory(Category.FOOD);

        productManager.groupProductsByCategory();

        productManager.removeProduct(Category.ELECTRONICS, "Washing machine");

        productManager.printAllProducts();
    }
}
