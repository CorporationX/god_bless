package faang.school.godbless.DeliveryCoupons;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Order {
    private List<Product> productList;
    private double totalPrice;

    public Order(List<Product> productList) {
        this.productList = productList;
    }

    public void applyDiscount(PromoCode promoCode) {
        double discount = promoCode.getDiscount();
        for (Product product : productList) {
            product.setPrice(product.getPrice() - discount);
        }
    }

    public double getTotalPrice() {
        return productList.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
}
