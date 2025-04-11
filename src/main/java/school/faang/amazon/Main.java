package school.faang.amazon;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct(Category.CLOTHING, "Штаны");
        productManager.addProduct(Category.FOOD, "Snikers");
        productManager.addProduct(Category.ELECTRONICS, "Computer");
        productManager.addProduct(Category.CLOTHING, "Рубашка");
        productManager.addProduct(Category.OTHER, "Кубик рубика");
        productManager.addProduct(Category.CLOTHING, "Футболка");

        productManager.removeProduct(Category.OTHER, "Кубик рубика");

        System.out.println(productManager.findProductsByCategory(Category.FOOD));
        System.out.println(productManager.findProductsByCategory(Category.OTHER));

        productManager.printAllProducts();
    }
}
