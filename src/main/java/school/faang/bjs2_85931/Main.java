package school.faang.bjs2_85931;

import static school.faang.bjs2_85931.Product.Category.FOOD;
import static school.faang.bjs2_85931.Product.Category.MEDICINES;
import static school.faang.bjs2_85931.Product.Category.TECHNOLOGIES;

public class Main {
    public static void main(String[] args) {
        ProductManager.addProduct(FOOD, "pasta");
        ProductManager.addProduct(FOOD, "Coca-Cola");
        ProductManager.addProduct(FOOD, "Pepsi");

        ProductManager.addProduct(TECHNOLOGIES, "IPhone");

        ProductManager.addProduct(MEDICINES, "Aspirin");

        ProductManager.removeProduct(FOOD, "Pepsi");

        System.out.println(ProductManager.findProductsByCategory(FOOD) + "\n");

        ProductManager.printAllProducts();
    }
}
