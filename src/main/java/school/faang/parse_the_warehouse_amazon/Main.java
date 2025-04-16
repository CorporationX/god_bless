package school.faang.parse_the_warehouse_amazon;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {

        ProductManager productManager = new ProductManager();
        List<Product> productList = List.of(
                new Product("Помидор", Category.FOOD),
                new Product("Ноутбук", Category.ELECTRONICS),
                new Product("Юбка", Category.CLOTHING),
                new Product("Гарри Поттер", Category.BOOKS),
                new Product("Диван", Category.FURNITURE),
                new Product("Автомобиль", Category.OTHER),
                new Product("Библия", Category.BOOKS)
        );
        productList.forEach(product -> productManager.addProduct(product.getCategory(), product.getName()));
        log.info(String.valueOf(productManager.removeProduct(Category.BOOKS, "Гарри Гудини")));
        log.info(String.valueOf(productManager.findProductsByCategory(Category.BOOKS)));
        log.info(productManager.groupProductsByCategory().toString());
        productManager.addProduct(Category.OTHER, "Бензин");
        productManager.addProduct(Category.valueOf("OTHER"), "TEST");
        log.info(String.valueOf(productManager.addProduct(Category.OTHER, "Бензин")));
        productManager.printAllProducts();
    }
}
