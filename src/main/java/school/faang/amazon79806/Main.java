package school.faang.amazon79806;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct(Category.FOOD, "Бургеры");
        productManager.addProduct(Category.FOOD, "Бургеры");
        productManager.addProduct(Category.FOOD, "Рыба");
        productManager.addProduct(Category.ELECTRONICS, "Телефоны");
        productManager.addProduct(Category.ELECTRONICS, "Телевизоры");
        productManager.addProduct(Category.ELECTRONICS, "Компьютеры");
        productManager.addProduct(Category.CLOTHING, "Футболки");
        productManager.addProduct(Category.CLOTHING, "Пальто");
        productManager.addProduct(Category.OTHER, "Витамины");
        productManager.addProduct(Category.CLOTHING, "Носки");
        productManager.addProduct(Category.CLOTHING, "Шорты");

        System.out.println(productManager.getProducts());
        productManager.removeProduct(Category.FOOD, "Рыба");
        productManager.removeProduct(Category.FOOD, null);

        productManager.findProductsByCategory(Category.CLOTHING);

        Map<Category, List<Product>> map = productManager.groupProductsByCategory();
        for (Map.Entry<Category, List<Product>> prod : map.entrySet()) {
            System.out.println(prod);
        }
        productManager.printAllProducts();
    }
}
