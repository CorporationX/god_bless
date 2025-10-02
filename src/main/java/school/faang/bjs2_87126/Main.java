package school.faang.bjs2_87126;

public class Main {
    public static void main(String[] args) {
        ProductManager product = new ProductManager();
        product.addProduct(Category.FOOD, "Творог");
        product.addProduct(Category.FOOD, "Молоко 2,5%");
        product.addProduct(Category.FOOD, "Молоко 3,5%");
        product.removeProduct(Category.FOOD, "Молоко 3,5%");
        product.addProduct(Category.CLOTHING, "Перчатки");
        product.addProduct(Category.CLOTHING, "Шарф");
        product.addProduct(Category.CLOTHING, "Шапка");
        System.out.println(product.findProduct(Category.OTHER));
        System.out.println(product.groupProductsByCategory());
        product.printAllProducts();

    }
}
