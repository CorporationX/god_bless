package school.faang.bjs2_57110;

import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@NoArgsConstructor
public class ProductManager {

    private static final Logger log = LoggerFactory.getLogger(ProductManager.class);

    private static int currentId = 0;

    private final Set<Product> products = new HashSet<>();
    private final Map<Category, List<Product>> categoryMap = new HashMap<>();

    /**
     * Метоод добавления продукта во множество товаров, а также в список по категориям товаров
     *
     * @param category категория товара
     * @param name     наименование товара
     */
    public void addProduct(Category category, String name) {
        Product product = new Product(currentId++, name, category);
        products.add(product);
        categoryMap.putIfAbsent(category, new ArrayList<>());
        categoryMap.get(category).add(product);
        log.debug("Добавлен товар: {}", product);
    }

    /**
     * Метод удаления товара
     *
     * @see ProductManager#addProduct(Category, String)
     */
    public void removeProduct(Category category, String name) {
        Product productForDelete = null;
        for (Product product : products) {
            if (product.getName().equals(name) && product.getCategory().equals(category)) {
                productForDelete = product;
                break;
            }
        }
        if (productForDelete != null) {
            products.remove(productForDelete);
            categoryMap.get(category).remove(productForDelete);
            log.debug("Удален товар: {}", productForDelete);
        } else {
            log.debug("Отсутсвует товар: {}", name);
        }
    }

    /**
     * Метод поиска товаров по категории
     *
     * @return возвращает список товаров по его категории, при отсутствии категории возвращает пустой список
     * @see ProductManager#addProduct(Category, String)
     */
    public List<Product> findProductsByCategory(Category category) {
        List<Product> products = categoryMap.getOrDefault(category, new ArrayList<>());
        log.debug("Список товаров, соответствующий категории: {} \n {}", category.name(), products);
        return products;
    }

    /**
     * Группировка товаров "categoryMap" по категориям
     *
     */
    public void groupProductsByCategory() {
        for (Product product : products) {
            Category category = product.getCategory();
            List<Product> productList = categoryMap.putIfAbsent(category, new ArrayList<>());
            if (productList != null && !productList.contains(product)) {
                productList.add(product);
            }
        }
        log.debug("Товары сгруппированы по категориям:\n {}", categoryMap);
    }

    public void printAllProducts() {
        categoryMap.forEach((category, productList) -> {
            System.out.println("Категория: " + category + "\n"
                    + "Продукты: ");
            productList.forEach(product -> System.out.println(" - " + product.getName()));
        });
    }
}
