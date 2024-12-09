package school.faang.task_47256;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import school.faang.task_47256.model.Product;
import school.faang.task_47256.model.ProductOrder;
import school.faang.task_47256.model.UserProfile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        String basePath = System.getProperty("user.dir");
        String jsonInputFolderPath =
                basePath + "\\src\\main\\java\\school\\faang\\task_47256\\json\\";
        try {
            List<UserProfile> userProfiles = objectMapper.readValue(
                    new File(jsonInputFolderPath + "user_profiles.json"), new TypeReference<>() {
                    });
            List<Product> products = objectMapper.readValue(
                    new File(jsonInputFolderPath + "products.json"), new TypeReference<>() {
                    });
            List<ProductOrder> productOrders = objectMapper.readValue(
                    new File(jsonInputFolderPath + "product_orders.json"), new TypeReference<>() {
                    });

            productOrders = productOrders.stream()
                    .filter(productOrder -> productOrder.productId() <= 40)
                    .toList();

            RecommendationService recommendationService = new RecommendationService(
                    userProfiles,
                    products,
                    productOrders);

        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }
}
