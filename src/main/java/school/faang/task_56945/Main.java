package school.faang.task_56945;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct(Category.CLOTHING, "T-SHIRT");
        productManager.addProduct(Category.CLOTHING, "JEANS");
        productManager.addProduct(Category.FOOD, "SOUP");
        productManager.addProduct(Category.FOOD, "CHEETOS");
        productManager.addProduct(Category.ELECTRONICS, "IPHONE");
        productManager.addProduct(Category.ELECTRONICS, "ANDROID");
    }
}
