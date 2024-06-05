package faang.school.godbless.amazon;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

  private static final String PRODUCTS_CATEGORY_VALUE = "Продукты категории: ";
  private static final String CATEGORY_VALUE = "Категория: ";
  private static final String SEPARATOR = ". ";

  public static void main(String[] args) {
    Set<Product> products = Set.of(
        new Product(1, "HP", "laptop"),
        new Product(2, "Apple", "laptop"),
        new Product(3, "Samsung", "phone"),
        new Product(4, "iPhone", "phone"),
        new Product(5, "Xiaomi", "phone"),
        new Product(6, "Bosh", "dishwasher"),
        new Product(7, "Electrolux", "dishwasher")
    );

    showGroupedProduct(productGrouping(products));
  }

  /**
   * Метод для группировки товаров по категориям.
   * @param products множество товаров
   * @return map, которая сгруппирована по катериям товара.
   * Ключ типа String (категория товара, значение типа List<Product> (список товаров в данной категории)
   */
  private static Map<String, List<Product>> productGrouping(Set<Product> products) {
    return products.stream()
        .collect(Collectors.groupingBy(Product::category));
  }

  /**
   * Метод для вывода информации о товарах в каждой категории.
   * @param groupedProduct сгруппированный товар.
   */
  private static void showGroupedProduct(Map<String, List<Product>> groupedProduct) {
    for (var entry : groupedProduct.entrySet()) {
      System.out.println(CATEGORY_VALUE + entry.getKey() + SEPARATOR +
          PRODUCTS_CATEGORY_VALUE + entry.getValue());
    }
  }

}
