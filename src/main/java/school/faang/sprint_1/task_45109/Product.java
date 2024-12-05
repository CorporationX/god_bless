package school.faang.sprint_1.task_45109;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.*;

import static school.faang.sprint_1.task_45109.Main.productCategories;

@Getter
@NoArgsConstructor
public class Product {
    private static int counterId = 0;
    int id;
    String name;
    String category;

    public Product(String name, String category) {
        this.id = generateId();
        this.name = name;
        this.category = category;
    }

    void addItem(String category, String name) {
        Product product = new Product(name, category);
        productCategories.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
    }

    void removeItem(String category, String name) {
        List<Product> products = productCategories.get(category);
        if (products != null) {
            products.removeIf(product -> product.getName().contains(name));
            if (products.isEmpty()) {
                productCategories.remove(category);
            }
        }
    }

    void findItemsByCategory(String category) {
        if (!productCategories.containsKey(category)) {
            System.out.printf("List of products by category %s not founded\n", category);
        } else {
            System.out.println(productCategories.get(category));

        }
    }

    private static int generateId() {
        return ++counterId;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id
                + ", name='" + name + '\''
                + ", category='" + category
                + '\'' + '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Product product = (Product) object;
        return Objects.equals(name, product.name) && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category);
    }
}
