package school.faang.bjs2_86026;

public class App {
    public static void main(String[] args) {
        final ProductManager productManager = new ProductManager();

        productManager.addProduct(Category.ELECTRONICS, "Phone");
        productManager.addProduct(Category.ELECTRONICS, "Watch");
        productManager.addProduct(Category.CLOTHING, "Skirt");
        productManager.addProduct(Category.CLOTHING, "Jeans");
        productManager.addProduct(Category.FOOD, "Apple");
        productManager.addProduct(Category.FOOD, "Orange");

        productManager.printAllProducts();

        System.out.println("\nFind by category " + Category.OTHER);
        System.out.println(productManager.findProductsByCategory(Category.OTHER));

        System.out.println("\nFind by category " + Category.FOOD);
        System.out.println(productManager.findProductsByCategory(Category.FOOD));

        System.out.println("\nPrint all products");
        productManager.removeProduct(Category.CLOTHING, "Jeans");
        productManager.printAllProducts();

        System.out.println("\nGroup by category");
        System.out.println(productManager.groupProductsByCategory());
    }
}