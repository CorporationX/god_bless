package school.faang.BJS2_56917;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct(Category.FOOD, "Hamburger");
        productManager.addProduct(Category.FOOD, "Pizza");

        productManager.addProduct(Category.ELECTRONICS, "Laptop");
        productManager.addProduct(Category.ELECTRONICS, "Smartphone");

        productManager.addProduct(Category.CLOTHING, "T-Shirt");
        productManager.addProduct(Category.CLOTHING, "Jeans");

        productManager.addProduct(Category.OTHER, "Book");
        productManager.addProduct(Category.OTHER, "Toy");
        productManager.printAllProducts();

        productManager.groupProductsByCategory();
        productManager.printAllProducts();


        productManager.findProductsByCategory(Category.CLOTHING);
        productManager.removeProduct(Category.CLOTHING, "Jeans");
        productManager.printAllProducts();
    }
}
