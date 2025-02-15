package school.faang.amazonwarehouse;

public class Main {
    public static void main(String[] args) {

        ProductManager manager = new ProductManager();

        manager.addProduct(Category.FOOD, "Chips");
        manager.addProduct(Category.ELECTRONICS, "iPhone");
        manager.addProduct(Category.ELECTRONICS, "HP Envy 17");
        manager.addProduct(Category.CLOTHING, "Vans");
        manager.addProduct(Category.OTHER, "Pillow");
        manager.addProduct(Category.FOOD, "Fruits");
        manager.addProduct(Category.OTHER, "Ring");
        manager.addProduct(Category.ELECTRONICS, "Ring");

        manager.removeProduct(Category.ELECTRONICS, "Ring");
        manager.findProductsByCategory(Category.CLOTHING);
        manager.groupProductsByCategory();
        manager.printAllProducts();
    }
}
