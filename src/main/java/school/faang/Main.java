package school.faang;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //Test:
        Product apples = new Product("Apples", Product.Category.FOOD);
        Product iphone = new Product("Iphone", Product.Category.ELECTRONICS);
        Product cap = new Product("Cap", Product.Category.CLOTHING);
        Product bicycle = new Product("Bicycle", Product.Category.OTHER);
        Product melon = new Product("Melon", Product.Category.FOOD);
        Product jeans = new Product("Jeans", Product.Category.CLOTHING);
        Product oranges = new Product("Oranges", Product.Category.FOOD);
        
        ProductManager.addProduct(Product.Category.FOOD, apples.getName());
        ProductManager.addProduct(Product.Category.ELECTRONICS, iphone.getName());
        ProductManager.addProduct(Product.Category.CLOTHING, cap.getName());
        ProductManager.addProduct(Product.Category.OTHER, bicycle.getName());
        ProductManager.addProduct(Product.Category.FOOD, melon.getName());
        ProductManager.addProduct(Product.Category.CLOTHING, jeans.getName());
        ProductManager.addProduct(Product.Category.FOOD, oranges.getName());

        Map<Product.Category, List<Product>> productsByCategories = ProductManager.groupProductsByCategories();
        ProductManager.printAllProducts(productsByCategories);
    }
}
