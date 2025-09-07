package school.faang.bjs2_85972;

import school.faang.bjs2_85972.product.Product;
import school.faang.bjs2_85972.product.ProductManager;

import java.util.List;

import static school.faang.bjs2_85972.product.Product.Category.CLOTHING;
import static school.faang.bjs2_85972.product.Product.Category.ELECTRONICS;
import static school.faang.bjs2_85972.product.Product.Category.FOOD;
import static school.faang.bjs2_85972.product.Product.Category.OTHER;


public class Main {
    public static void main(String[] args) {
        ProductManager.addProduct(FOOD, "Банан");
        ProductManager.addProduct(FOOD, "Печенье");
        ProductManager.addProduct(FOOD, "Яблоко");

        ProductManager.addProduct(ELECTRONICS, "Телевизор");
        ProductManager.addProduct(ELECTRONICS, "Стиральная машина");
        ProductManager.addProduct(ELECTRONICS, "Микроволновка");

        ProductManager.addProduct(CLOTHING, "Брюки");
        ProductManager.addProduct(CLOTHING, "Платье");
        ProductManager.addProduct(CLOTHING, "Носки");

        ProductManager.addProduct(OTHER, "Турецкие Сабли (сувенир)");
        ProductManager.addProduct(OTHER, "Картина \"Тысяча и Один цвет\"");
        ProductManager.addProduct(OTHER, "Бюст Ленина");
        ProductManager.printAllProducts();

        List<Product> groupOfCategory = ProductManager.findProductsByCategory(ELECTRONICS);
        groupOfCategory.forEach(System.out::println);
        System.out.println();

        ProductManager.removeProduct(FOOD, "Печенье");
        ProductManager.removeProduct(ELECTRONICS, "Стиральная машина");
        ProductManager.removeProduct(CLOTHING, "Носки");
        ProductManager.removeProduct(OTHER, "Бюст Ленина");
        ProductManager.printAllProducts();
    }
}
