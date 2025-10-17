package school.faang.bjs2_87008;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        //Test:
        Product apples = new Product("Apples", Category.FOOD);
        Product iphone = new Product("Iphone", Category.ELECTRONICS);
        Product cap = new Product("Cap", Category.CLOTHING);
        Product bicycle = new Product("Bicycle", Category.OTHER);
        Product melon = new Product("Melon", Category.FOOD);
        Product jeans = new Product("Jeans", Category.CLOTHING);
        Product oranges = new Product("Oranges", Category.FOOD);
        
        ProductManager.addProduct(Category.FOOD, apples.getName());
        ProductManager.addProduct(Category.ELECTRONICS, iphone.getName());
        ProductManager.addProduct(Category.CLOTHING, cap.getName());
        ProductManager.addProduct(Category.OTHER, bicycle.getName());
        ProductManager.addProduct(Category.FOOD, melon.getName());
        ProductManager.addProduct(Category.CLOTHING, jeans.getName());
        ProductManager.addProduct(Category.FOOD, oranges.getName());

        Map<Category, List<Product>> productsByCategories = ProductManager.groupProductsByCategories();
        ProductManager.printAllProducts(productsByCategories);
    }
}
