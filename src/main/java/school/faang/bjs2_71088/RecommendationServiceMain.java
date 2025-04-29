package school.faang.bjs2_71088;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public enum RecommendationServiceMain {
    INSTANCE;

    private final List<UserProfile> profiles;
    private final List<Product> products;
    private final List<ProductOrder> orders;

    RecommendationServiceMain() {
        this.profiles = new ArrayList<>();
        this.products = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public void configure(List<UserProfile> profiles, List<Product> products, List<ProductOrder> orders) {
        this.profiles.addAll(profiles);
        this.products.addAll(products);
        this.orders.addAll(orders);
    }
}
