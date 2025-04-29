package school.faang.bjs2_71088;

import java.util.ArrayList;
import java.util.List;
import java.io.File;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class ParseJson {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode rootNode = mapper.readTree(new File(
                "/home/user/god_bless/src/main/java/school/faang/bjs2_71088/resources/user_profiles.json"
            ));
            if (rootNode.isArray()) {
                for (JsonNode userNode : rootNode) {
                    int userId = userNode.get("userId").asInt();
                    String gender = userNode.get("gender").asText();
                    int age = userNode.get("age").asInt();
                    String location = userNode.get("location").asText();
                    
                    System.out.println("User ID: " + userId);
                    System.out.println("Gender: " + gender);
                    System.out.println("Age: " + age);
                    System.out.println("Location: " + location);
                    
                    System.out.println("Interests:");
                    JsonNode interestsNode = userNode.get("interests");
                    for (JsonNode interest : interestsNode) {
                        System.out.println("- " + interest.asText());
                    }
                    System.out.println("-----");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<UserProfile> parseUserProfiles() {
        ObjectMapper mapper = new ObjectMapper();
        List<UserProfile> profiles = new ArrayList<>();
        try {
            JsonNode rootNode = mapper.readTree(
                new File("/home/user/god_bless/src/main/java/school/faang/bjs2_71088/resources/user_profiles.json")
            );
            if (rootNode.isArray()) {
                for (JsonNode userNode : rootNode) {
                    int userId = userNode.get("userId").asInt();
                    String gender = userNode.get("gender").asText();
                    int age = userNode.get("age").asInt();
                    String location = userNode.get("location").asText();
                    JsonNode interests = userNode.get("interests");
                    List<String> interestsList = new ArrayList<>();
                    for (JsonNode interest : interests) {
                        interestsList.add(interest.asText());
                    }
                    UserProfile profile2 = new UserProfile(userId, gender, age, location, interestsList);
                    profiles.add(profile2);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return profiles;
    }

    public static List<Product> parseProducts() {
        List<Product> products = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode rootNode = mapper.readTree(new File(
                "/home/user/god_bless/src/main/java/school/faang/bjs2_71088/resources/products.json"
            ));
            
            if (rootNode.isArray()) {
                for (JsonNode productNode : rootNode) {
                    int productId = productNode.get("productId").asInt();
                    String productName = productNode.get("name").asText();
                    String category = productNode.get("category").asText();
                    double price = productNode.get("price").asDouble();
                    JsonNode tagsNode = productNode.get("tags");
                    List<String> tags = new ArrayList<>();
                    for (JsonNode tag : tagsNode) {
                        tags.add(tag.asText());
                    }
                    Product product1 = new Product(productId, productName, category, price, tags);
                    products.add(product1);
                }
            }
        } catch (Exception e) {
            log.warn(e.getMessage());
        }

        return products;
    }

    public static List<ProductOrder> parseOrders() {
        List<ProductOrder> orders = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try {
            JsonNode rootNode = mapper.readTree(new File(
                "/home/user/god_bless/src/main/java/school/faang/bjs2_71088/resources/product_orders.json"
            ));
            if (rootNode.isArray()) {
                for (JsonNode orderNode : rootNode) {
                    int userId = orderNode.get("userId").asInt();
                    int productId = orderNode.get("productId").asInt();
                    String orderDate = orderNode.get("orderDate").asText();
                    LocalDateTime orderDateTime = LocalDateTime.parse(orderDate, formatter);
                    ProductOrder order = new ProductOrder(userId, productId, orderDateTime);
                    orders.add(order);
                }
            }
        } catch (Exception e) {
            log.warn(e.getMessage());
        }

        return orders;
    }
}
