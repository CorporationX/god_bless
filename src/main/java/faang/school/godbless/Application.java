package faang.school.godbless;

import faang.school.godbless.Notification.Notification;

import java.util.*;

import java.time.LocalDateTime;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        List<UserProfile> users = Arrays.asList(
                new UserProfile(1, "MALE", 20, "Москва", Arrays.asList("Сноубординг", "Фантастика", "Видеоигры")),
                new UserProfile(2, "FEMALE", 25, "Москва", Arrays.asList("Кулинария", "Фантастика", "Туризм"))
        );

        List<Product> products = Arrays.asList(
                new Product(123, "Ботинки для сноуборда", "Спортивные товары", 5000, Arrays.asList("Спорт", "Сноубординг", "Зимний спорт")),
                new Product(124, "Книга фантастики", "Книги", 700, Arrays.asList("Фантастика", "Литература"))
        );

        List<ProductOrder> orders = Arrays.asList(
                new ProductOrder(1, 123, LocalDateTime.of(2022, 11, 5, 18, 48, 24)),
                new ProductOrder(2, 124, LocalDateTime.of(2022, 11, 6, 10, 15, 00))
        );

        RecommendationService recommendationService = new RecommendationService(users, products, orders);

        System.out.println("Рекомендации по интересам:");
        List<Product> recommendedProducts = recommendationService.recommendProductsByInterests(1);
        recommendedProducts.forEach(product -> System.out.println(product.getName()));

        System.out.println("Популярные товары среди похожих пользователей:");
        List<Product> topPurchasedProducts = recommendationService.recommendTopPurchasedProducts(1);
        topPurchasedProducts.forEach(product -> System.out.println(product.getName()));

        System.out.println("Категория для скидки:");
        String discountCategory = recommendationService.recommendCategoryForDiscount(1);
        System.out.println(discountCategory);
    }
}
