package school.faang.sprint_2.task_bjs247301;

import java.io.IOException;
import java.util.List;

public class Main {
    private static final int MAX_PRODUCTS_FOR_SIMILAR_USERS = 2;
    private static final int MAX_RECOMMEND_CATEGORIES_FOR_DISCOUNT = 1;
    private static final String PRODUCT_FILENAME = "products.json";
    private static final String USERS_FILENAME = "user_profiles.json";
    private static final String ORDERS_FILENAME = "product_orders.json";
    private static final List<Product> PRODUCTS = getData(PRODUCT_FILENAME, Product.class);
    private static final List<UserProfile> USERS = getData(USERS_FILENAME, UserProfile.class);
    private static final List<ProductOrder> ORDERS = getData(ORDERS_FILENAME, ProductOrder.class);

    public static void main(String[] args) {
        RecommendationService service = new RecommendationService(USERS, PRODUCTS, ORDERS);

        System.out.println(service.recommendProduct(6));
        System.out.println(service.mostPopularProducts(6, MAX_PRODUCTS_FOR_SIMILAR_USERS));
        System.out.println(service.recommendCategoriesForDiscount(6, MAX_RECOMMEND_CATEGORIES_FOR_DISCOUNT));
    }

    private static <T> List<T> getData(String filename, Class<T> clazz) {
        try {
            return DataParser.loadData(filename, clazz);
        } catch (IOException e) {
            throw new RuntimeException("Error while loading file: " + filename);
        }
    }
}
