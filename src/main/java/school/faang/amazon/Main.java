package school.faang.amazon;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct(Category.FOOD, "Яблоко");
        productManager.addProduct(Category.FOOD, "Груша");
        productManager.addProduct(Category.ELECTRONICS, "Телефон");
        productManager.addProduct(Category.CLOTHING, "Куртка");
        productManager.addProduct(Category.OTHER, "Хомяк");

        productManager.printAllProducts();
        productManager.removeProduct(Category.ELECTRONICS, "Телефон");
        productManager.removeProduct(Category.OTHER, "Кролик");
        productManager.findProductsByCategory(Category.ELECTRONICS);
        productManager.findProductsByCategory(Category.FOOD);
        productManager.printAllProducts();
    }
}
