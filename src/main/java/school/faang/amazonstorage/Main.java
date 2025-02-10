package school.faang.amazonstorage;

public class Main {
    public static void main(String[] args) {
        ProductManager magazine = new ProductManager();

        magazine.addProduct(Category.FOOD, "Carrot");
        magazine.addProduct(Category.FOOD, "Banana");
        magazine.addProduct(Category.FOOD, "Cucumber");
        magazine.addProduct(Category.ELECTRONICS, "TV");
        magazine.addProduct(Category.ELECTRONICS, "Mouse");
        magazine.addProduct(Category.ELECTRONICS, "Keyboard");
        magazine.addProduct(Category.ELECTRONICS, "Webcam");

        magazine.printAllProducts();
        magazine.printAllProductsFromSet();

        magazine.removeProduct(Category.FOOD, "Carrot");
        magazine.removeProduct(Category.ELECTRONICS, "Webcam");
        magazine.removeProduct(Category.ELECTRONICS, "Webcam");

        magazine.printAllProducts();
        magazine.printAllProductsFromSet();

        magazine.findProductsByCategory(Category.FOOD);
        magazine.findProductsByCategory(Category.CLOTHING);
    }
}
