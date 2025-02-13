package school.faang.bjs2_57225;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct(Category.FOOD, "Apple");
        productManager.addProduct(Category.ELECTRONICS, "PC");
        productManager.addProduct(Category.FOOD, "Orange");
        productManager.addProduct(Category.ELECTRONICS, "PS5");

        productManager.printAllProducts();

        productManager.removeProduct(Category.ELECTRONICS, "PS5");
        productManager.removeProduct(Category.FOOD, "Apple");

        productManager.groupProductsByCategory();
        System.out.println(productManager.findProductsByCategory(Category.ELECTRONICS));

        productManager.printAllProducts();
    }
}
