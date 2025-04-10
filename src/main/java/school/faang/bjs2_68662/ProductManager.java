package school.faang.bjs2_68662;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ProductManager {

    private Set<Product> products;

    public void addProduct(Category category, String name, int id) {
        products.add(new Product(id, name, category));
    }

    public void removeProduct(Category category, String name) {
        boolean isRemoved = products.removeIf(product -> product.getName().equals(name)
                                                       && product.getCategory().equals(category));
        if (isRemoved) {
            System.out.println("Removed product " + name + " from category " + category);
        } else {
            System.out.println("Failed to remove product " + name + " from category " + category);
        }

    }

    public Set<Product> findProductsByCategory(Category category) {
        if (products.stream().noneMatch(product -> product.getCategory().equals(category))) {
            return new HashSet<>();
        }
        return products.stream().filter(product -> product.getCategory() == category)
                .collect(Collectors.toSet());
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        return products.stream().collect(Collectors.groupingBy(Product::getCategory));
    }

    public void printAllProducts() {
        groupProductsByCategory().forEach((category, productList) -> {
            System.out.printf("Category: %s\n", category);
            System.out.println("Products: ");
            productList.forEach(product -> System.out.println("- " + product.getName()));
        });
    }
}

