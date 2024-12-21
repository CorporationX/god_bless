package school.faang.sprint_2.task_47311;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

public class Main {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        try {
            RecommendationService recommendationService = new RecommendationService(
                    getObjectsFromFile("/task_47311/user_profiles.json", new TypeReference<>(){}),
                    getObjectsFromFile("/task_47311/products.json", new TypeReference<>(){}),
                    getObjectsFromFile("/task_47311/product_orders.json", new TypeReference<>(){}));

            List<UserProfile> userProfiles = recommendationService.getUserProfiles();
            System.out.println(userProfiles);
            int userId = userProfiles.get(new Random().nextInt(userProfiles.size())).userId();

            System.out.println("Printing of recommended products to user " + userId);
            recommendationService.getRecommendedProducts(userId).forEach(System.out::println);

            System.out.println("Printing of recommended products to user from similar users " + userId);
            recommendationService.getRecommendedProductsFromSimilarUsers(userId).forEach(System.out::println);

            System.out.println("Printing discounting category " + userId);
            System.out.println(recommendationService.getDiscountedCategory(userId));
        } catch (IOException e) {
            System.out.println("Failed to load files");
            e.printStackTrace();
        }
    }

    private static <T> List<T> getObjectsFromFile(String fileName,
                                                  TypeReference<List<T>> typeReference) throws IOException {
        InputStream resourceAsStream = Main.class.getResourceAsStream(fileName);

        mapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
        return mapper.readValue(resourceAsStream, typeReference);
    }
}
