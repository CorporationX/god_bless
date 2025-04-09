package school.faang.bjs2_68676;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
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
        var categoryByGroups = productManager.groupProductsByCategory();
        productManager.printAllProducts();
    }
}