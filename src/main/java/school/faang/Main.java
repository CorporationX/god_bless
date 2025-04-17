package school.faang;

import java.util.ArrayList;

import static school.faang.Category.ELECTRONICS;
import static school.faang.Category.FOOD;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct(FOOD,"Воцат");
        productManager.addProduct(FOOD,"Каша");
        productManager.addProduct(FOOD,"Сыр");
        productManager.addProduct(FOOD,"Хінкалі");

        productManager.addProduct(ELECTRONICS,"iPad");
        productManager.addProduct(ELECTRONICS,"Phone");

        productManager.printAllProducts();
        System.out.println();
        ArrayList<String> groupedProductList = productManager.findProductsByCategory(ELECTRONICS);
        for (String product : groupedProductList) {
            System.out.println(product);
        }

        System.out.println();

        productManager.removeProduct(FOOD,"Воцат");
        System.out.println();

        productManager.printAllProducts();
    }
}
