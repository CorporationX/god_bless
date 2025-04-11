package school.faang.bjs2_68788;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct(Category.FOOD, "Apple");
        productManager.addProduct(Category.FOOD, "Bread");
        productManager.addProduct(Category.FOOD, "Pear");
        productManager.addProduct(Category.ELECTRONICS, "Laptop");
        productManager.addProduct(Category.ELECTRONICS, "Phone");
        productManager.addProduct(Category.ELECTRONICS, "Monitor");
        productManager.addProduct(Category.CLOTHING, "Pants");
        productManager.addProduct(Category.CLOTHING, "Hat");
        productManager.addProduct(Category.CLOTHING, "Socks");
        productManager.addProduct(Category.OTHER, "Sticker");
        productManager.addProduct(Category.OTHER, "Bag");
        productManager.addProduct(Category.OTHER, "Pen");

        productManager.printAllProducts();

        productManager.removeProduct(Category.FOOD, "Apple");
        productManager.removeProduct(Category.FOOD, "Pear");

        productManager.printAllProducts();

        System.out.println(productManager.findProductsByCategory(Category.ANIMALS));
    }
}
