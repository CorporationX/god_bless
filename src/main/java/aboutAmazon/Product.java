package aboutAmazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.HashMap;
import java.util.HashSet;

public class Product {
    private int id;
    private String name;
    private String category;

    public Product(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Objects.equals(name, product.name) && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, category);
    }

    public static HashMap<String, List<Product>> groupProductsByCategory(HashSet<Product> productHashSet) {
        HashMap<String, List<Product>> stringListHashMap = new HashMap<>();
        for (Product elem : productHashSet) {
            if (!stringListHashMap.containsKey(elem.category)) {
                stringListHashMap.put(elem.category, new ArrayList<>());
            }
            stringListHashMap.get(elem.category).add(elem);
        }
        return stringListHashMap;
    }

    public static void printCategoriesAndProducts(Map<String, List<Product>> stringListMap) {
        for (Map.Entry<String, List<Product>> entry : stringListMap.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            for (Product elem : entry.getValue()) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
