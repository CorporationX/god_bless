package school.faang.wearhouse;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ProductManager productManager = new ProductManager();

        productManager.addProduct(Category.FOOD, "Milk");
        productManager.addProduct(Category.FOOD, "Cheese");
        productManager.addProduct(Category.ELECTRONICS, "Phone");
        productManager.addProduct(Category.CLOTHING, "Shirt");
        productManager.addProduct(Category.OTHERS, "Flower");

        productManager.removeProduct(Category.FOOD, "Cookie");
        productManager.removeProduct(Category.CLOTHING, "Shirt");

        productManager.addProduct(Category.CLOTHING, "Jeans");
        productManager.printAllCategories();

        List<Product> products = productManager.findProductsByCategory(Category.FOOD);
        for (Product product : products) {
            System.out.println(product.getId() + " - " + product.getName() + " - " + product.getCategory());
        }

        productManager.groupProductsByCategory();
        productManager.printAllCategories();
    }
}
