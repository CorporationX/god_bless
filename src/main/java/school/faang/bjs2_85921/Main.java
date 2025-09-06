package school.faang.bjs2_85921;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct(Category.FOOD, "Apple");
        productManager.addProduct(Category.FOOD, "Beer");
        productManager.addProduct(Category.FOOD, "Bread");
        productManager.addProduct(Category.ELECTRONICS, "TELE");
        productManager.addProduct(Category.ELECTRONICS, "Computer");
        productManager.addProduct(Category.CLOTHING, "Shoes");
        productManager.addProduct(Category.CLOTHING, "Coat");
        productManager.addProduct(Category.OTHER, "House");
        productManager.addProduct(Category.OTHER, "Car");
        productManager.addProduct(Category.OTHER, "Cat");

        productManager.removeProduct(Category.OTHER, "Cat");
        productManager.removeProduct(Category.OTHER, "qwe");

        productManager.findProductsByCategory(Category.FOOD);

        productManager.printAllProducts();
    }
}
