package school.faang.bjs268676;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct(Category.FOOD, "Milk");
        productManager.addProduct(Category.FOOD, "Bread");
        productManager.addProduct(Category.ELECTRONICS, "Phone");
        productManager.addProduct(Category.ELECTRONICS, "TV");
        productManager.addProduct(Category.CLOTHING, "T-Shirt");
        productManager.addProduct(Category.CLOTHING, "Shoes");
        productManager.addProduct(Category.CLOTHING, "Pants");
        productManager.addProduct(Category.OTHER, "Ball");
        productManager.addProduct(Category.OTHER, "Table");
        productManager.addProduct(Category.OTHER, "Chair");
        productManager.removeProduct(Category.CLOTHING, "Shoes");
        List<Product> electronics = productManager.findProductsByCategory(Category.FOOD);
        for (Product product : electronics) {
            System.out.println(product);
        }
        Map<Category, List<Product>> categoryByGroups = productManager.groupProductsByCategory();
        for (Category category : categoryByGroups.keySet()) {
            for (Product product : categoryByGroups.get(category)) {
                System.out.println(product);
            }
        }
        productManager.printAllProducts();
    }
}