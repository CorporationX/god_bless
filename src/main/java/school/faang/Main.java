package school.faang;

import school.faang.service.Category;
import school.faang.service.Product;
import school.faang.service.ProductManager;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct(Category.FOOD, "Шоколадка");
        productManager.addProduct(Category.ELECTRONICS, "Телевизор");
    }
}