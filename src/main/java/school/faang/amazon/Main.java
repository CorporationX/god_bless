package school.faang.amazon;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        productManager.addProduct(Category.FOOD, "пельмени");
        productManager.addProduct(Category.FOOD, "картошка");
        productManager.addProduct(Category.FOOD, "картошка");
        productManager.addProduct(Category.OTHER, "Кондиционер");
        productManager.addProduct(Category.ELECTRONICS, "Телевизор");
        productManager.addProduct(Category.ELECTRONICS, "Кондиционер");

        productManager.printAllProducts();

        System.out.println(productManager.groupProductsByCategory());

        productManager.removeProduct(Category.FOOD, "картошка");

        System.out.println(productManager.findProductsByCategory(Category.FOOD));

        System.out.println(productManager.groupProductsByCategory());

        productManager.printAllProducts();
    }
}