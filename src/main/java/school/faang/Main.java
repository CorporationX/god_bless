package school.faang;

import school.faang.service.Category;
import school.faang.service.ProductManager;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct(Category.FOOD, "Шоколадка");
        productManager.addProduct(Category.FOOD, "Батон");
        productManager.addProduct(Category.ELECTRONICS, "Телевизор");
        productManager.addProduct(Category.ELECTRONICS, "Наушники");
        productManager.addProduct(Category.CLOTHING, "Шуба");
        productManager.addProduct(Category.CLOTHING, "Трусы");
        productManager.addProduct(Category.OTHER, "Космический корабль");

        productManager.removeProduct(Category.FOOD, "Батон");
        productManager.removeProduct(Category.ELECTRONICS, "Наушники");

        productManager.printAllProducts();
    }
}