package school.faang.bjs2_79895;

public class Shop {
    public static void main(String[] args) {
        ProductManager product = new ProductManager();
        product.addProduct(Category.FOOD, "cheese");
        product.addProduct(Category.FOOD, "meat");
        product.addProduct(Category.DRINKS, "cola");
        product.addProduct(Category.ELECTRONICS, "ps5");

        product.removeProduct(Category.FOOD, "meat");

        product.addProduct(Category.FOOD, "milk");

        product.findProductsByCategory(Category.FOOD);

        System.out.println(product.groupProductsByCategory());
        System.out.println("----------------");

        product.printAllProducts();
    }
}
