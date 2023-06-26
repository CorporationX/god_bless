package faang.school.godbless.secondSprint.RecommenderSystem;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<UserProfile> users = List.of(
                new UserProfile(1, "male", 20, "Moscow", List.of("Gaming", "Programming")),
                new UserProfile(2, "male", 20, "Moscow", List.of("Gaming", "Reading", "Sport")),
                new UserProfile(3, "male", 20, "Moscow", List.of("Skiing", "Programming")),
                new UserProfile(4, "female", 21, "Moscow", List.of("Chess", "Sport"))
        );
        List<Product> products = List.of(
                new Product(1, "PC", "Appliances", 100, List.of("Programming", "Gaming")),
                new Product(2, "Java book", "Book", 100, List.of("Programming", "Reading")),
                new Product(3, "Ball", "Sport", 100, List.of("Sport")),
                new Product(4, "Chess board", "Board games", 100, List.of("Chess"))
        );
        List<ProductOrder> orders = List.of(
                new ProductOrder(1, 1, LocalDate.now()),
                new ProductOrder(1, 2, LocalDate.now()),
                new ProductOrder(2, 1, LocalDate.now()),
                new ProductOrder(2, 3, LocalDate.now()),
                new ProductOrder(3, 1, LocalDate.now()),
                new ProductOrder(3, 2, LocalDate.now()),
                new ProductOrder(4, 3, LocalDate.now())
        );
        RecommendationService service = new RecommendationService(users, products, orders);

        System.out.println(service.filterProductByInterest(1));
        System.out.println(service.filterProductByInterest(2));
        System.out.println(service.filterProductByInterest(3));
        System.out.println(service.filterProductByInterest(4) + "\n");

        System.out.println(service.findMostPopularProduct(1));
        System.out.println(service.findMostPopularProduct(2));
        System.out.println(service.findMostPopularProduct(3));
        System.out.println(service.findMostPopularProduct(4));

        System.out.println(service.findCategoryForDiscount(1));
        System.out.println(service.findCategoryForDiscount(2));
        System.out.println(service.findCategoryForDiscount(3));
        System.out.println(service.findCategoryForDiscount(4));
    }
}
