package school.faang.bjs2_85941;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        productManager.addProduct(Category.CLOTHING, "Рубашка");
        productManager.addProduct(Category.CLOTHING, "Рубашка");
        productManager.addProduct(Category.CLOTHING, "Кофта");
        productManager.addProduct(Category.CLOTHING, "Куртка");
        productManager.addProduct(Category.ELECTRONICS, "Iphone");
        productManager.addProduct(Category.ELECTRONICS, "TV");
        productManager.addProduct(Category.ELECTRONICS, "Xbox One");
        productManager.addProduct(Category.FOOD, "Пицца");
        productManager.addProduct(Category.FOOD, "Пельмени");
        productManager.addProduct(Category.FOOD, "Морс");
        productManager.addProduct(Category.OTHER, "Машина");
        productManager.addProduct(Category.OTHER, "Квартира");
        productManager.addProduct(Category.OTHER, "Кружка");

        productManager.removeProduct(Category.OTHER, "Кружка");
        productManager.removeProduct(Category.FOOD, "Васаби");

        System.out.println(productManager.findProductsByCategory(Category.ELECTRONICS).toString());

        productManager.printAllProducts();
    }
}
