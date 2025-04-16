package school.faang.amazonwarehouse;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        productManager.addProduct(Category.FOOD, "Apple");
        productManager.addProduct(Category.FOOD, "Banana");
        productManager.addProduct(Category.ELECTRONICS, "Computer");
        productManager.addProduct(Category.CLOTHING, "Shirt");
        productManager.addProduct(Category.OTHER, "Paper");
        productManager.addProduct(Category.FOOD, "Apple");

        productManager.removeProduct(Category.OTHER, "Pape");
        productManager.removeProduct(Category.OTHER, "Paper");

        productManager.findProductsByCategory(Category.FOOD);
        productManager.findProductsByCategory(Category.OTHER);

        productManager.groupProductsByCategory();
        productManager.printAllProducts();

    }
}
