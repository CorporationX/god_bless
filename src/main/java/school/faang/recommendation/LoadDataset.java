package school.faang.recommendation;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

@Slf4j
public class LoadDataset {
    private static final String RESOURCES_DIR = "src/main/resources/";
    private static final String USER_PROFILES_FILE = "user_profiles.json";
    private static final String PRODUCTS_FILE = "products.json";
    private static final String ORDERS_FILE = "product_orders.json";

    public static List<UserProfile> loadUserProfiles() {
        return loadFromFile(RESOURCES_DIR + USER_PROFILES_FILE, new TypeToken<List<UserProfile>>() {
        }.getType());
    }

    public static List<Product> loadProducts() {
        return loadFromFile(RESOURCES_DIR + PRODUCTS_FILE, new TypeToken<List<Product>>() {
        }.getType());
    }

    public static List<ProductOrder> loadProductOrders() {
        return loadFromFile(RESOURCES_DIR + ORDERS_FILE, new TypeToken<List<ProductOrder>>() {
        }.getType());
    }

    private static <T> T loadFromFile(String filePath, Type type) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, type);
        } catch (FileNotFoundException e) {
            log.error("File not found: {}", filePath, e);
        } catch (JsonSyntaxException e) {
            log.error("Invalid JSON syntax in file: {}", filePath, e);
        } catch (IOException e) {
            log.error("Error reading file: {}", filePath, e);
        }
        return null;
    }
}
