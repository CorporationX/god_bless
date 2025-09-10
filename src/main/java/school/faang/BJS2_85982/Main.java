package school.faang.BJS2_85982;

public class Main {
    public static void main(String[] args) {
        ProductManager pm = new ProductManager();
        pm.addProduct(Category.ELECTRONICS, "Smartphone");
        pm.addProduct(Category.FOOD, "Apple");
        pm.removeProduct(Category.ELECTRONICS, "Smartphone");
        pm.addProduct(Category.ELECTRONICS, "Laptop");
        pm.addProduct(Category.ELECTRONICS, "Mac");
        pm.addProduct(Category.FOOD, "Bread");
        pm.findProductsByCategory(Category.ELECTRONICS);
        pm.printAllProducts();
    }
}
