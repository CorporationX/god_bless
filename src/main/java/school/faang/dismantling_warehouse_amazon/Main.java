package school.faang.dismantling_warehouse_amazon;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct(Category.FOOD, "cheese");
        productManager.addProduct(Category.FOOD, "meat");
        productManager.addProduct(Category.FOOD, "egg");
        productManager.addProduct(Category.ELECTRONICS, "USB");
        productManager.addProduct(Category.ELECTRONICS, "Type-C");
        productManager.addProduct(Category.OTHER, "termos");
        productManager.addProduct(Category.OTHER, "termos");
        productManager.removeProduct(Category.FOOD, "egg");
        productManager.printAllProducts();
    }
}
