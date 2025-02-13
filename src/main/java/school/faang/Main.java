package school.faang;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        productManager.addProduct(Category.FOOD, "Burger");
        productManager.addProduct(Category.FOOD, "Lasagna");
        productManager.addProduct(Category.FOOD, "Oatmeal");
        productManager.addProduct(Category.CLOTHING, "Jacket");
        productManager.addProduct(Category.CLOTHING, "Shirt");
        productManager.addProduct(Category.OTHER, "Dumbbell");

        productManager.printAllProducts();
        System.out.println(productManager.findProductsByCategory(Category.CLOTHING));

        productManager.removeProduct(Category.FOOD, "Burger");
        productManager.removeProduct(Category.CLOTHING, "Jacket");

        productManager.groupProductsByCategory();
        productManager.printAllProducts();
    }
}