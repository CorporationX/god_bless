package amazon.warehouse;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        productManager.addProduct(Category.BOOKS, "Lord of the rings");
        productManager.addProduct(Category.BOOKS, "1984");
        productManager.addProduct(Category.BOOKS, "Dune");
        productManager.addProduct(Category.FOOD, "Tomatos");
        productManager.addProduct(Category.FOOD, "French fries");
        productManager.addProduct(Category.FOOD, "Pizza");
        productManager.addProduct(Category.CLOTHING, "Shirt");
        productManager.addProduct(Category.CLOTHING, "Pants");

        productManager.printAllProducts();

        productManager.removeProduct(1, Category.BOOKS, "1984");
    }
}
