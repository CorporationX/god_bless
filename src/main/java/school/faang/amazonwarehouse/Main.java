package school.faang.amazonwarehouse;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        productManager.addProduct(Category.FOOD, "Apple");
        productManager.addProduct(Category.FOOD, "Bread");
        productManager.addProduct(Category.ELECTRONICS, "Laptop");
        productManager.addProduct(Category.ELECTRONICS, "Smartphone");
        productManager.addProduct(Category.CLOTHING, "T-Shirt");

        System.out.println("Все продукты, сгруппированные по категориям:");
        productManager.printAllProducts();

        System.out.println("\nПродукты категории FOOD:");
        System.out.println(productManager.findProductsByCategory(Category.FOOD));
        System.out.println("\n");

        productManager.removeProduct(Category.FOOD, "Apple");
        System.out.println("\n");


        System.out.println("\nВсе продукты после удаления:");
        productManager.printAllProducts();
    }
}