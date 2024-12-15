package school.faang.sprint_2.task_47600;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<UserProfile> userProfiles = DataLoader.loadData("user_profiles.json", UserProfile.class);
        List<Product> products = DataLoader.loadData("products.json", Product.class);
        List<ProductOrder> productOrders = DataLoader.loadData("product_orders.json", ProductOrder.class);

        RecommendationService recommendationService = new RecommendationService(userProfiles, products, productOrders);

        System.out.println("1. Печатаю товарные рекомендации на основе интересов...");
        recommendationService.printProductList(recommendationService.getUserRecommendByInterests(4));

        System.out.println("2. Печатаю рекомендации популярных товаров среди схожих пользователей...");
        recommendationService.printProductList(recommendationService.getPopularUsersProduct(10));

        System.out.println("3. Печатаю категорию для предложения скидки на основе покупок пользователя...");
        System.out.println(recommendationService.getCategoryDiscountForUser(10));

    }
}
