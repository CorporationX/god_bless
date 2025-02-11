package school.faang.bjs2_57110;

import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
public class ProductManager {

    private static final Logger log = LoggerFactory.getLogger(ProductManager.class);

    private static int currentId = 0;

    private final Set<Product> products = new HashSet<>();
    private final Map<Category, List<Product>> categoryMap = new HashMap<>();

    /**
     * Метод добавления продукта во множество товаров, а также в список по категориям товаров
     *
     * @param category категория товара
     * @param name     наименование товара
     */
    public void addProduct(Category category, String name) {
        Product product = new Product(currentId++, name, category);
        products.add(product);
        categoryMap.computeIfAbsent(category, c -> new ArrayList<>()).add(product);
        log.debug("Добавлен товар: {}", product);
    }

    /**
     * Метод удаления товара
     *
     * @see ProductManager#addProduct(Category, String)
     */
    public void removeProduct(Category category, String name) {
        Objects.requireNonNull(category, "Категория не может быть null");
        Objects.requireNonNull(name, "Имя товара не может быть null");

        List<Product> productsByCategory = categoryMap.get(category);
        if (productsByCategory == null) {
            log.debug("Категория {} отсутствует", category);
            return;
        }

        boolean removed = productsByCategory.removeIf(product -> product.getName().equals(name));
        if (removed) {
            products.removeIf(product -> product.getName().equals(name) && product.getCategory().equals(category));
            log.debug("Удален товар: {} из категории {}", name, category);
        } else {
            log.debug("Отсутствует товар: {}", name);
        }
    }

    /**
     * Метод поиска товаров по категории
     *
     * @return возвращает список товаров по его категории, при отсутствии категории возвращает пустой список
     * @see ProductManager#addProduct(Category, String)
     */
    public List<Product> findProductsByCategory(Category category) {
        List<Product> productsList = categoryMap.getOrDefault(category, new ArrayList<>());
        log.debug("Список товаров, соответствующий категории: {} \n {}", category.name(), productsList);
        return productsList;
    }

    /**
     * Группировка товаров "categoryMap" по категориям
     */
    public void groupProductsByCategory() {
        categoryMap.clear();
        products.forEach(product -> {
            categoryMap.computeIfAbsent(product.getCategory(), v -> new ArrayList<>()).add(product);
        });
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
