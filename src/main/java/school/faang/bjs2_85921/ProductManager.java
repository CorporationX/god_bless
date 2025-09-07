package school.faang.bjs2_85921;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductManager {
    private Set<Product> products = new HashSet<>();
    AtomicCounter atomicCounter = new AtomicCounter();

    public void addProduct(Category category, String name) {
        atomicCounter.incrementId();
        Product product = new Product(name, category, atomicCounter.incrementId());
        products.add(product);
    }

    public void removeProduct(Category category, String name) {
        if (name.isBlank() && (Objects.isNull(category))) {
            System.out.println("you passed an empty field");
            return;
        }
        Optional<Product> product = products.stream()
                .filter(p -> p.getCategory().equals(category) && p.getName().equals(name))
                .findFirst();

        if (product.isPresent()) {
            products.remove(product.get());
        } else {
            System.out.println("There is no such product!");
        }
    }

    public List<Product> findProductsByCategory(Category category) {

        return products.stream()
                .filter(product -> Objects.equals(product.getCategory(), category))
                .collect(Collectors.toList());

    }

    public Map<Category, List<String>> groupingProductsByCategory() {
        return products.stream().collect(Collectors.groupingBy(Product::getCategory,
                Collectors.mapping(Product::getName, Collectors.toList())));
    }

    public void printAllProducts() {
        Map<Category, List<String>> groupProduct = groupingProductsByCategory();
        for (Map.Entry<Category, List<String>> entry : groupProduct.entrySet()) {
            System.out.printf("Category: %s \n", entry);
            System.out.println("Product:");
            entry.getValue().forEach(name -> System.out.printf("- %s \n", name));
            System.out.println();

        }
    }
}
