package school.faang;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String currentDirectoryPath = new File("").getAbsolutePath()
                .concat("\\src\\main\\java\\school\\faang\\");
        ObjectMapper mapper = new ObjectMapper();

        try {
            String json = Files.readString(Paths.get(currentDirectoryPath.concat("user_profiles.json")));
            UserProfile[] userProfiles = mapper.readValue(json, UserProfile[].class);

            json = Files.readString(Paths.get(currentDirectoryPath.concat("products.json")));
            Product[] products = mapper.readValue(json, Product[].class);

            json = Files.readString(Paths.get(currentDirectoryPath.concat("product_orders.json")));
            ProductOrder[] productOrders = mapper.readValue(json, ProductOrder[].class);

            RecommendationService service = new RecommendationService(
                    Arrays.stream(userProfiles).toList(),
                    Arrays.stream(products).toList(),
                    Arrays.stream(productOrders).toList());

            List<Product> userProducts = service.getProductByUserInterests(4);
            for (Product product : userProducts) {
                System.out.println(product);
            }
            System.out.println();

            List<Product> favoriteProducts = service.getTopTheSameFavorites(1);
            for (Product product : favoriteProducts) {
                System.out.println(product);
            }
            System.out.println();

            String productWithDiscount = service.getProductsWithDiscount(1);
            System.out.println(productWithDiscount);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    String.format("Не удалось прочитать файл с данными: %s", e.getMessage()));
        }
    }
}
