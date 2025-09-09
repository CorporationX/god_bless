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

        List<Product> groupOfFood = ProductManager.findProductsByCategory(FOOD);
        groupOfFood.forEach(System.out::println);
        System.out.println();

        List<Product> groupOfElectronics = ProductManager.findProductsByCategory(ELECTRONICS);
        groupOfElectronics.forEach(System.out::println);
        System.out.println();

        List<Product> groupOfClothing = ProductManager.findProductsByCategory(CLOTHING);
        groupOfClothing.forEach(System.out::println);
        System.out.println();

        List<Product> groupOfOther = ProductManager.findProductsByCategory(OTHER);
        groupOfOther.forEach(System.out::println);
        System.out.println();

        ProductManager.removeProduct(FOOD, "Печенье");
        ProductManager.removeProduct(ELECTRONICS, "Стиральная машина");
        ProductManager.removeProduct(CLOTHING, "Носки");
        ProductManager.removeProduct(OTHER, "Бюст Ленина");
        ProductManager.printAllProducts();

        List<Product> newGroupOfFood = ProductManager.findProductsByCategory(FOOD);
        newGroupOfFood.forEach(System.out::println);
        System.out.println();

        List<Product> newGroupOfElectronics = ProductManager.findProductsByCategory(ELECTRONICS);
        newGroupOfElectronics.forEach(System.out::println);
        System.out.println();

        List<Product> newGroupOfClothing = ProductManager.findProductsByCategory(CLOTHING);
        newGroupOfClothing.forEach(System.out::println);
        System.out.println();

        List<Product> newGroupOfOther = ProductManager.findProductsByCategory(OTHER);
        newGroupOfOther.forEach(System.out::println);
        System.out.println();
    }
}
