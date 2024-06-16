package groupingAmazonProduct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Product {

    protected String name;
    protected String category;
    protected int id;

    public String toString() {
        String text = "";
        text += "Name: " + this.name + " ";
        text += "Cattegory: " + this.category + " ";
        text += "ID: " + this.id + " ";

        return text;
    }

    protected Product(String name, String category, int id) {
        this.name = name;
        this.category = category;
        this.id = id;
    }

    protected static HashMap<String, List<Product>> productCollectionAfterGrouping =
            new HashMap<>();

    protected static void groupingByCategory(HashSet<Product> productSetCollection) {

        for (Product product : productSetCollection) {
            String categoryProduct = product.category;
            if (productCollectionAfterGrouping.containsKey(categoryProduct)) {
                List<Product> listProduct = productCollectionAfterGrouping.get(categoryProduct);
                listProduct.add(product);
                productCollectionAfterGrouping.put(categoryProduct, listProduct);
            } else {
                List<Product> newListProduct = new ArrayList<>();
                newListProduct.add(product);
                productCollectionAfterGrouping.put(categoryProduct, newListProduct);
            }
        }
    }

    protected static void productCategoryInformation(String category) {
        if (productCollectionAfterGrouping.containsKey(category)) {
            System.out.println(productCollectionAfterGrouping.get(category));
        } else {
            System.out.println("Нет такой категории товара : " + category );
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

        groupingByCategory(collectionProduct);

        productCategoryInformation("одежда");
        productCategoryInformation("обувь");
        productCategoryInformation("быт.химия");
        productCategoryInformation("головные уборы");

    }
}
