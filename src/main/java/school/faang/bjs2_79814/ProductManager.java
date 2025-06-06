package school.faang.bjs2_79814;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ProductManager {
    private final Set<Product> products = new HashSet<>();

    public final static AtomicInteger id = new AtomicInteger(0);

    public Product addProduct(Category category, String name) {
        Product product = new Product(id.incrementAndGet(), name, category);
        //Но тут используется Set<Product>, все равно нужно делать проверку на наличие товара, для оптимизации?
        //при добавлении он же просто перетрет уже находящийся товар и не будет дубликатов. IDE пишет "Unnecessary 'contains()' check"
        //id не используется в hashcode и equals
        boolean idAdded = products.add(product);
        System.out.println(idAdded ? "Товар добавлен" : "Товар уже в системе");

        return product;
    }

    //Без id? В hashcode и equal не включать id или сделать перегрузку конструктора для создания без id?
    // Зачем в рамках задачи id, он нигде не используется?
    public void removeProduct(Category category, String name) {
        Product product = new Product(name, category);
        boolean isRemoved = products.remove(product);
        System.out.println(isRemoved ? "Товар удален" : "Товар не найден в системе");
    }

    public Set<Product> findProductsByCategory(Category category) {
        return products.stream()
                .filter(product -> product.getCategory() == category)
                .collect(Collectors.toSet());
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
    }

    public void printAllProducts() {
        Map<Category, List<Product>> groupedProducts = groupProductsByCategory();
        groupedProducts.forEach(((category, products) -> {
            System.out.println("Категория: " + category);
            products.forEach(product -> System.out.println("- " + product.getName()));
            System.out.println();
        }));
    }

}
