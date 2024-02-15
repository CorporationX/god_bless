package RecommendSystem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserProfile user1 = new UserProfile(1, "MALE", 20, "Москва", Arrays.asList("Сноубординг", "Фантастика", "Видеоигры"));
        UserProfile user2 = new UserProfile(2, "FEMALE", 25, "Санкт-Петербург", Arrays.asList("Футбол", "Кино", "Шоппинг"));
        UserProfile user3 = new UserProfile(3, "MALE", 20, "Москва", Arrays.asList("Гитара", "Сноубординг", "Рок"));

        Product product1 = new Product(123, "Ботинки для сноуборда", "Спортивные товары", 5000.0, Arrays.asList("Спорт", "Сноубординг", "Зимний спорт"));
        Product product2 = new Product(456, "Футбольный мяч", "Спортивные товары", 1000.0, Arrays.asList("Спорт", "Футбол"));
        Product product3 = new Product(789, "Наушники", "Электроника", 2000.0, Arrays.asList("Аудио", "Музыка", "Гаджеты"));
        Product product4 = new Product(101, "Акустическая гитара", "Музыкальные инструменты", 3000.0, Arrays.asList("Музыка", "Гитара", "Рок"));
        Product product5 = new Product(202, "Футболка", "Одежда", 500.0, Arrays.asList("Мода", "Шоппинг"));

        ProductOrder order1 = new ProductOrder(1, 123, LocalDateTime.now().minusDays(5));
        ProductOrder order2 = new ProductOrder(2, 456, LocalDateTime.now().minusDays(10));
        ProductOrder order3 = new ProductOrder(1, 789, LocalDateTime.now().minusDays(2));
        ProductOrder order4 = new ProductOrder(2, 123, LocalDateTime.now().minusDays(8));
        ProductOrder order5 = new ProductOrder(3, 101, LocalDateTime.now().minusDays(3));
        ProductOrder order6 = new ProductOrder(3, 202, LocalDateTime.now().minusDays(7));
        ProductOrder order7 = new ProductOrder(2, 101, LocalDateTime.now().minusDays(4));
        ProductOrder order8 = new ProductOrder(2, 202, LocalDateTime.now().minusDays(6));

        List<UserProfile> userProfiles = Arrays.asList(user1, user2, user3);
        List<Product> products = Arrays.asList(product1, product2, product3, product4, product5);
        List<ProductOrder> productOrders = Arrays.asList(order1, order2, order3, order4, order5, order6, order7, order8);

        RecommendationService recommendationService = new RecommendationService(userProfiles, products, productOrders);

        System.out.println("\nРекомендации по интересам пользователя:");
        List<Product> recommendedProducts = recommendationService.getRecommendedProductsByInterests(1);
        recommendedProducts.forEach(product -> System.out.println(" - " + product.getName()));

        System.out.println("\nНаиболее покупаемые товары другими пользователями, которые похожи на пользователя:");
        List<Product> updatedTopPurchasedProducts = recommendationService.getTopPurchasedProducts(1);
        updatedTopPurchasedProducts.forEach(product -> System.out.println(" - " + product.getName()));

        System.out.println("\nКатегория с персональной скидкой:");
        String categoryWithDiscount = recommendationService.getCategoryWithPersonalDiscount(1);
        System.out.println(" - " + categoryWithDiscount);
    }
}


