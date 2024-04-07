package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
  private static Set<Product> products = new HashSet<>();

  public static void main(String[] args) {
    products.add(new Product(1, "name", "category"));
    products.add(new Product(2, "name1", "category1"));
    products.add(new Product(3, "name2", "category1"));
    products.add(new Product(4, "name3", "category"));
    printProductsByCategories();
  }

  public static Map<String, List<Product>> getAllProductsGroppingByCategory(Set<Product> products) {
    Map<String, List<Product>> result = new HashMap<>();
    for (Product product : products) {
      result.computeIfAbsent(product.getCategory(), p -> new ArrayList<>()).add(product);
    }
    return result;
  }
  public static void printProductsByCategories() {
    for (Map.Entry<String, List<Product>> product : getAllProductsGroppingByCategory(products).entrySet()) {
      System.out.println(product.getKey());
      product.getValue().forEach(System.out::println);
    }
  }
}
