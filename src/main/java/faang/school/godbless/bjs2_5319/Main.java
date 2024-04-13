package faang.school.godbless.bjs2_5319;

public class Main {

    public static void main(String[] args) {

        RecommendationService recommendationService = new RecommendationService();

        recommendationService.findRecommendProductsForUserByUserId(1).forEach(System.out::println);

        System.out.println("\nRecommendations products for Vasya");
        recommendationService.findProductsForRelevantGroupUsers(1).forEach(System.out::println);

        System.out.println("\nMost popular category for Vasya");
        System.out.println(recommendationService.findCategoryForUserForSale(1));
    }
}
