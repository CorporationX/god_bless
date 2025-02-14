package school.faang.task_58962;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        System.out.println(productManager.addProduct(Category.FOOD, "Apple"));
        System.out.println(productManager.addProduct(Category.ELECTRONICS, "Laptop"));
        System.out.println(productManager.addProduct(Category.CLOTHING, "T-shirt"));
        System.out.println(productManager.addProduct(Category.CLOTHING, "Skirt"));
        System.out.println(productManager.addProduct(Category.ELECTRONICS, "Smartphone"));
        System.out.println(productManager.addProduct(Category.FOOD, "Bread"));

        System.out.println(productManager.findProduct(Category.CLOTHING));

        productManager.removeProduct(Category.CLOTHING, "Skirt");
        productManager.removeProduct(null, null);

        productManager.groupProductsByCategory();
        productManager.printAllProducts();
    }
}
