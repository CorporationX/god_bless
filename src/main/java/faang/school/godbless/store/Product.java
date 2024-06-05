package faang.school.godbless.store;


import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@ToString
public class Product {

    private int id;

    private String name;

    private String category;

    public static Map<String, List<Product>> packaging(Set<Product> products) {

        if (products.isEmpty()) {
            System.out.println("Is empty");
        }

        Map<String, List<Product>> packProduct = new HashMap<>();

        for (Product product: products) {
            List<Product> isThere = packProduct.get(product.category);

            if (isThere==null) {
                List<Product> productList = new ArrayList<>();
                productList.add(product);
                packProduct.put(product.category, productList);
            } else {
                isThere.add(product);
            }
        }

        return packProduct;
    }


}
