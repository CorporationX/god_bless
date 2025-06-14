package school.faang.task_79960;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct(Category.ELECTRONICS, "Ipad");
        productManager.addProduct(Category.ELECTRONICS, "Iphone");
        productManager.addProduct(Category.ELECTRONICS, "Notebook");
        productManager.addProduct(Category.FOOD, "Apple");
        productManager.addProduct(Category.FOOD, "Mint");
        productManager.addProduct(Category.FOOD, "Cola");

        productManager.findProductsByCategory(Category.ELECTRONICS);
        productManager.findProductsByCategory(Category.FOOD);

        productManager.printAllProducts();
        productManager.removeProduct(Category.ELECTRONICS, "Ipad");
        productManager.printAllProducts();

    }
}
