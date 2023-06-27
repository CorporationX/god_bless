package faang.school.godbless.recommendationSystem;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        List<UserProfile> userProfiles = new ArrayList<>();
        userProfiles.add(new UserProfile(1, "MALE", 20, "Moscow", List.of("Snowboarding", "Fiction", "Video Games")));
        userProfiles.add(new UserProfile(2, "FEMALE", 25, "London", List.of("Hiking", "Music", "Travel")));
        userProfiles.add(new UserProfile(3, "MALE", 30, "New York", List.of("Football", "Movies", "Cooking")));

        List<Product> products = new ArrayList<>();
        products.add(new Product(123, "Snowboard Boots", "Sports Goods", 199.99, List.of("Sports", "Snowboarding", "Winter Sports")));
        products.add(new Product(124, "Book: Fiction Novel", "Books", 19.99, List.of("Fiction", "Reading", "Novel")));
        products.add(new Product(125, "Video Game: RPG", "Electronics", 59.99, List.of("Gaming", "RPG", "Adventure")));
        products.add(new Product(126, "Hiking Backpack", "Outdoor Gear", 79.99, List.of("Hiking", "Camping", "Outdoor")));
        products.add(new Product(127, "Music Album", "Music", 9.99, List.of("Music", "Album", "Pop")));
        products.add(new Product(128, "Cooking Utensils Set", "Kitchenware", 49.99, List.of("Cooking", "Kitchen", "Utensils")));


        List<ProductOrder> orders = new ArrayList<>();
        orders.add(new ProductOrder(1, 123, "2022-11-05 18:48:24"));
        orders.add(new ProductOrder(2, 124, "2022-12-10 09:15:37"));
        orders.add(new ProductOrder(1, 125, "2023-01-20 14:30:51"));
        orders.add(new ProductOrder(3, 126, "2023-02-05 21:05:12"));
        orders.add(new ProductOrder(2, 127, "2023-03-15 12:20:43"));
        orders.add(new ProductOrder(1, 128, "2023-04-25 17:55:59"));
        orders.add(new ProductOrder(3, 123, "2023-05-30 10:40:18"));

        RecommendationService recommendationService = new RecommendationService(userProfiles, products, orders);

        int userId = 1;

        System.out.println("Recommended products for User ID: " + userId);
        List<Product> recommendedProducts = recommendationService.getRecommendedProductsByInterests(userId);
        for (Product product : recommendedProducts) {
            System.out.println(product.getName());
        }

        System.out.println("\nPopular products for User ID: " + userId);
        List<Product> popularProducts = recommendationService.getPopularProductsByAgeAndLocationAndGender(userId);
        for (Product product : popularProducts) {
            System.out.println(product.getName());
        }

        System.out.println("\nCategory for personal discount for User ID: " + userId);
        String category = recommendationService.getCategoryForPersonalDiscount(userId);
        System.out.println(category);
    }

}
