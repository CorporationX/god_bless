package delivery_coupons;

import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;


@EqualsAndHashCode
public class Order {
    private volatile List<Product> products = new ArrayList<>();

    public void applyDiscount(PromoCode promoCode) {
        products.forEach(product -> product.setPrice(product.getPrice() * (1.0 - promoCode.getDiscount() / 100.0)));
    }

    public double getTotalPrice() {
        return products.stream()
                .map(Product::getPrice)
                .reduce(0.0, (Double::sum));
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new NullPointerException("Product must be exists");
        }
        products.add(product);
    }
}
