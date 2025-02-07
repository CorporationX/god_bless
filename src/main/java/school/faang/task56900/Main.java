package school.faang.task56900;

import school.faang.task56900.service.Category;
import school.faang.task56900.service.ProductManager;

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

        System.out.println("Поиск " + Category.CLOTHING);
        System.out.println(productManager.findProductsByCategory(Category.CLOTHING) + "\n");
    }
}