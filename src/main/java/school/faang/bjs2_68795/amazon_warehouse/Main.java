package school.faang.bjs2_68795.amazon_warehouse;

import lombok.extern.slf4j.Slf4j;
import school.faang.bjs2_68795.amazon_warehouse.exceptions.ProductAlreadyExistsException;
import school.faang.bjs2_68795.amazon_warehouse.exceptions.ProductNotFoundException;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        productManager.addProduct(Category.FOOD, "Apple");
        productManager.addProduct(Category.FOOD, "Tea");
        productManager.addProduct(Category.CLOTHING, "T-shirt");
        productManager.addProduct(Category.ELECTRONICS, "Laptop");
        productManager.addProduct(Category.ELECTRONICS, "Smartphone");
        productManager.addProduct(Category.ELECTRONICS, "Washing Machine");
        productManager.addProduct(Category.CLOTHING, "Hat");
        try {
            productManager.addProduct(Category.FOOD, "Apple");
        } catch (ProductAlreadyExistsException e) {
            log.error(e.getMessage());
        }

        productManager.printAllProducts();

        List<Product> electronicsList = productManager.findProductsByCategory(Category.ELECTRONICS);
        log.info("{} list: {}", Category.ELECTRONICS, electronicsList);
        List<Product> otherList = productManager.findProductsByCategory(Category.OTHER);
        log.info("{} list: {}", Category.OTHER, otherList);

        try {
            productManager.removeProduct(Category.CLOTHING, "Hat");
        } catch (ProductNotFoundException e) {
            log.error(e.getMessage());
        }
        try {
            productManager.removeProduct(Category.CLOTHING, "Jeans");
        } catch (ProductNotFoundException e) {
            log.error(e.getMessage());
        }

        productManager.printAllProducts();
    }
}
