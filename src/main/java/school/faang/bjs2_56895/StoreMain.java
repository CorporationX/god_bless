package school.faang.bjs2_56895;

public class StoreMain {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        productManager.addProduct(Category.FOOD, "Apple");
        productManager.addProduct(Category.FOOD, "Bread");
        productManager.addProduct(Category.ELECTRONICS, "Laptop");
        productManager.addProduct(Category.FOOD, "Laptop");
        productManager.addProduct(Category.ELECTRONICS, "Laptop");
        productManager.addProduct(Category.ELECTRONICS, "Smartphone");

        productManager.printAllProducts();
        separator();

        System.out.println(productManager.findProductByCategory(Category.FOOD));
        separator();

        productManager.removeProduct(Category.FOOD, "Apple");
        productManager.printAllProducts();
        separator();

        productManager.groupProductsByCategory();
        productManager.printAllProducts();
    }

    static void separator() {
        System.out.println("============================");
    }
}
