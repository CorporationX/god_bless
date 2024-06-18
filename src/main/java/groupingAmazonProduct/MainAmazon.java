package groupingAmazonProduct;

import java.util.*;

public class MainAmazon {
    public static Map<String, List<Product>> groupingByCategory(HashSet<Product> productSetCollection) {
        HashMap<String, List<Product>> mapByGrouping = new HashMap<>();
        for (Product product : productSetCollection) {
            if (mapByGrouping.containsKey(product.getCategory())) {
                List<Product> listProduct = mapByGrouping.get(product.getCategory());
                listProduct.add(product);
                mapByGrouping.put(product.getCategory(), listProduct);
            } else {
                List<Product> newListProduct = new ArrayList<>();
                newListProduct.add(product);
                mapByGrouping.put(product.getCategory(), newListProduct);
            }
        }
        return mapByGrouping;
    }
    public static void productCategoryInformation(Map<String, List<Product>> anyMap) {
        for (Map.Entry entry : anyMap.entrySet()) {
            System.out.println("Category: " + entry.getKey() + ", Product: " + entry.getValue());
        }
    }
    public static void main(String[] args) {
        HashSet<Product> collectionProduct = new HashSet<>();

        Product product1 = new Product("шампунь", "быт.химия", 12345);
        Product product2 = new Product("гель для душа", "быт.химия", 12555);
        Product product3 = new Product("кроссовки", "обувь", 34545);
        Product product4 = new Product("ботинки", "обувь", 567845);
        Product product5 = new Product("футболка", "одежда", 234223);
        Product product6 = new Product("пиджак", "одежда", 87564);
        Product product7 = new Product("куртка", "одежда", 184833);

        collectionProduct.add(product1);
        collectionProduct.add(product2);
        collectionProduct.add(product3);
        collectionProduct.add(product4);
        collectionProduct.add(product5);
        collectionProduct.add(product6);
        collectionProduct.add(product7);

        HashMap<String, List<Product>> productCollectionAfterGrouping = new HashMap<>();

        productCollectionAfterGrouping.putAll(groupingByCategory(collectionProduct));
        productCategoryInformation(productCollectionAfterGrouping);
    }
}
