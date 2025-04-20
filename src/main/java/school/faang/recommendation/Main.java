package school.faang.recommendation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        int userId = 9;

        RecommendationService recommendationService = new RecommendationService(
                LoadDataset.loadUserProfiles(),
                LoadDataset.loadProducts(),
                LoadDataset.loadProductOrders());
        log.info("Рекомендации на основе интересов для пользователя c id: {}", userId);
        for (Product product : recommendationService.recommendByInterests(userId)) {
            log.info(product.getName());
        }
        log.info("Рекомендации на основе интересов для пользователя c id: {}", userId);

        log.info("Рекомендации популярных товаров среди схожих пользователей для пользователя c id: {}", userId);
        for (Product product : recommendationService.recommendPopularProductSimilarUsers(userId)) {
            log.info(product.getName());
        }

        log.info("Категория для скидки для пользователя c id: {}", userId);
        log.info(recommendationService.recommendDiscountCategory(userId));
    }
}
