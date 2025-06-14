package school.faang.bjs279923;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello BJS2-79923!");

        ProductManager productManager = new ProductManager();
        testAddProduct(productManager);

        productManager.printAllProducts();
        testFindProductsByCategory(productManager);

        testRemoveProduct(productManager);
        productManager.printAllProducts();
    }

    private static void testAddProduct(ProductManager productManager) {
        productManager.addProduct(Category.FOOD, "Pasta");
        productManager.addProduct(Category.FOOD, "Pasta");
        productManager.addProduct(Category.CLOTHING, "Hat");
        productManager.addProduct(Category.CLOTHING, "Shirt");
        productManager.addProduct(Category.CLOTHING, "Pants");
        productManager.addProduct(Category.CLOTHING, "Cloak");
        productManager.addProduct(Category.CLOTHING, "Helmet");
        productManager.addProduct(Category.CLOTHING, "Boots");
        productManager.addProduct(Category.ELECTRONICS, "iPhone");
        productManager.addProduct(Category.ELECTRONICS, "Laptop");
        productManager.addProduct(Category.ELECTRONICS, "TV");
        productManager.addProduct(Category.ELECTRONICS, "Switch");
        productManager.addProduct(Category.OTHER, "Toy");
    }

    private static void testFindProductsByCategory(ProductManager productManager) {
        System.out.println(productManager.findProductsByCategory(Category.CLOTHING));
    }

    private static void testRemoveProduct(ProductManager productManager) {
        System.out.printf(
                "The product is removed by productManager: %b\n",
                productManager.removeProduct(Category.CLOTHING, "Cloak"));
    }
}
