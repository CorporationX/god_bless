package school.faang.recommendationsystem;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class JsonDataLoader {

    private ObjectMapper objectMapper = new ObjectMapper();

    public List<UserProfile> loadUserProfiles(String filePath) throws Exception {
        UserProfile[] userProfiles = objectMapper.readValue(new File(filePath), UserProfile[].class);
        return List.of(userProfiles);
    }

    public List<Product> loadProducts(String filePath) throws Exception {
        Product[] products = objectMapper.readValue(new File(filePath), Product[].class);
        return List.of(products);
    }

    public List<ProductOrder> loadProductOrders(String filePath) throws Exception {
        ProductOrder[] productOrders = objectMapper.readValue(new File(filePath), ProductOrder[].class);
        return List.of(productOrders);
    }
}
