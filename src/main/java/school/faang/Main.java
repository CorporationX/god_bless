package school.faang;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        //Test:
        Product apples = new Product("Apples", Category.Categories.FOOD);
        Product iphone = new Product("Iphone", Category.Categories.ELECTRONICS);
        Product cap = new Product("Cap", Category.Categories.CLOTHING);
        Product bicycle = new Product("Bicycle", Category.Categories.OTHER);
        Product melon = new Product("Melon", Category.Categories.FOOD);
        Product jeans = new Product("Jeans", Category.Categories.CLOTHING);
        Product oranges = new Product("Oranges", Category.Categories.FOOD);
        
        ProductManager.addProduct(Category.Categories.FOOD, apples.getName());
        ProductManager.addProduct(Category.Categories.ELECTRONICS, iphone.getName());
        ProductManager.addProduct(Category.Categories.CLOTHING, cap.getName());
        ProductManager.addProduct(Category.Categories.OTHER, bicycle.getName());
        ProductManager.addProduct(Category.Categories.FOOD, melon.getName());
        ProductManager.addProduct(Category.Categories.CLOTHING, jeans.getName());
        ProductManager.addProduct(Category.Categories.FOOD, oranges.getName());

        Map<Category.Categories, List<Product>> productsByCategories = ProductManager.groupProductsByCategories();
        ProductManager.printAllProducts(productsByCategories);
    }
}
