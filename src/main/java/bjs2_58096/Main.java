package bjs2_58096;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String currentDirectoryPath = new File("").getAbsolutePath()
                .concat("\\src\\main\\resources\\");
        ObjectMapper mapper = new ObjectMapper();

        try {
            String json = Files.readString(Paths.get(currentDirectoryPath.concat("user_profiles.json")));
            List<UserProfile> userProfiles = mapper.readValue(json, new TypeReference<>() {
            });

            json = Files.readString(Paths.get(currentDirectoryPath.concat("products.json")));
            List<Product> products = mapper.readValue(json, new TypeReference<>() {
            });

            json = Files.readString(Paths.get(currentDirectoryPath.concat("product_orders.json")));
            List<ProductOrder> productOrders = mapper.readValue(json, new TypeReference<>() {
            });

            RecommendationService service = new RecommendationService(
                    userProfiles,
                    products,
                    productOrders);

            System.out.println("Метод для рекомендаций на основе интересов");
            List<Product> userProducts = service.getProductByUserInterests(4);
            for (Product product : userProducts) {
                System.out.println(product);
            }
            System.out.println();

            System.out.println("Метод для рекомендаций популярных товаров среди схожих пользователей");
            List<Product> favoriteProducts = service.getTopTheSameFavorites(1);
            for (Product product : favoriteProducts) {
                System.out.println(product);
            }
            System.out.println();

            System.out.println("Метод для определения категории со скидкой");
            String productWithDiscount = service.getProductsWithDiscount(1);
            System.out.println(productWithDiscount);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    String.format("Не удалось прочитать файл с данными: %s", e.getMessage()));
        }
    }
}
