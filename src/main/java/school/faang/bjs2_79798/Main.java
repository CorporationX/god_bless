package school.faang.bjs2_79798;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        productManager.addProduct(Category.FOOD, "Apple");
        productManager.addProduct(Category.FOOD, "Meat");
        productManager.addProduct(Category.CLOTHING, "Hat");
        productManager.addProduct(Category.ELECTRONICS, "Phone");
        productManager.addProduct(Category.OTHER, "Paper");

        productManager.printAllProducts();

        System.out.println(productManager.findProductByCategory(Category.FOOD));

        productManager.removeProduct(Category.FOOD, "Apple");
        productManager.removeProduct(Category.FOOD, "Meat");

        productManager.printAllProducts();
    }
}
