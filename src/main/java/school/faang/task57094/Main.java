package school.faang.task57094;

import school.faang.task57094.warehouse.Category;
import school.faang.task57094.warehouse.Product;
import school.faang.task57094.warehouse.ProductManager;

import java.util.List;
import java.util.Map;

import static school.faang.task57094.warehouse.Category.*;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        Map<Category, List<Product>> groupProducts = productManager.groupProductsByCategory();
        System.out.println(groupProducts);
        productManager.printAllProducts();
        productManager.removeProduct(ELECTRONICS, "MP3-плеер");
        productManager.addProduct(FOOD, "Пельмени");
        List<Product> electronicsProducts = productManager.findProductByCategory(ELECTRONICS);
        System.out.println(electronicsProducts);
        productManager.removeProduct(FOOD, "Хлеб");
        productManager.addProduct(FOOD, "Пельмени");
        productManager.addProduct(FOOD, "Сырники");
        productManager.findProductByCategory(FOOD);
        productManager.removeProduct(FOOD, "Сырники");
        List<Product> foodProducts = productManager.findProductByCategory(FOOD);
        for (Product product : foodProducts) {
            System.out.printf("id продукта %d, имя \"%s\", категория %s\n",
                    product.getId(), product.getName(), product.getCategory());
        }
        productManager.addProduct(OTHER, "Бумага");
        productManager.addProduct(OTHER, "Обои");
        groupProducts = productManager.groupProductsByCategory();
        System.out.println(groupProducts);
        productManager.printAllProducts();
    }
}
