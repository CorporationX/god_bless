package school.faang.godbless.bjs2_32286;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    Set<Product> products = Set.of(
        new Product(1, "Tomato", "Veggies"),
        new Product(2, "Beef", "Meat"),
        new Product(3, "Salmon", "Fish"),
        new Product(4, "Tuna", "Fish")
    );

    Map<String, List<Product>> groupedProducts = groupByCategories(products);
    printProductsByCategories(groupedProducts);
  }

  private static Map<String, List<Product>> groupByCategories(Set<Product> products) {
    Map<String, List<Product>> map = new HashMap<>();
    products.forEach(p -> map.computeIfAbsent(p.getCategory(), k -> new ArrayList<>()).add(p));
    return map;
  }

  private static void printProductsByCategories(Map<String, List<Product>> groupedProducts) {
    StringBuilder sb = new StringBuilder();
    for (Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
      sb.append(entry.getKey());
      sb.append(": ");
      sb.append(entry.getValue());
    }
    System.out.println(sb);
  }
}
