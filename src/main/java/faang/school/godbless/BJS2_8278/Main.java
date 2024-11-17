package faang.school.godbless.BJS2_8278;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
  static Set<Product> products = new HashSet<>();
  public static void main(String[] args) {
    products.add(new Product(1, "1", "1"));
    products.add(new Product(2, "2", "1"));
    products.add(new Product(3, "3", "2"));
    products.add(new Product(4, "4", "3"));

    getAllProducts(getGroupProducts(products));
  }

  public static Map<String, List<Product>> getGroupProducts(Set<Product> products) {
    Map<String, List<Product>> result = new HashMap<>();
    for (Product product : products) {
      result.computeIfAbsent(product.getCategory(), s -> new ArrayList<>()).add(product);
    }
    return result;
  }

  public static void getAllProducts(Map<String, List<Product>> filterProducts) {
    for (Map.Entry<String, List<Product>> entry : filterProducts.entrySet()) {
      System.out.println(entry.getKey() + " " + entry.getValue());
    }
  }
}
