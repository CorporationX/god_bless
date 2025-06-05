package school.faang.dismantling_warehouse_amazon;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct(Category.FOOD, "ches");
        productManager.addProduct(Category.FOOD, "meet");
        productManager.addProduct(Category.FOOD, "eag");
        productManager.addProduct(Category.ELECTRONICS, "USB");
        productManager.addProduct(Category.ELECTRONICS, "Type-C");
        productManager.addProduct(Category.OTHER, "ter");
        productManager.addProduct(Category.OTHER, "ter");
        productManager.removeProduct(Category.FOOD, "eag");
        productManager.printAllProducts();
    }
}
