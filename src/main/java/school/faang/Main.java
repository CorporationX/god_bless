package school.faang;

import static school.faang.Category.FOOD;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct(FOOD,"Воцат");
    }
}
