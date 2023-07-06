package faang.school.godbless.deliveryCoupons;

import java.text.DecimalFormat;
import java.util.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private List<Product> products;

    public Order(List<Product> products) {
        this.products = products;
    }

    public String getFormattedTotalPrice() {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        return decimalFormat.format(getTotalPrice());
    }

    public void applyDiscount(PromoCode promoCode) {
        if (promoCode != null && promoCode.isValidForOrder(this)) {
            double discount = promoCode.getDiscount();
            for (Product product : products) {
                double discountedPrice = product.getPrice() * (1 - discount);
                product.setPrice(discountedPrice);
            }
        }
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        if (products != null) {
            for (Product product : products) {
                totalPrice += product.getPrice();
            }
        }
        return totalPrice;
    }

}
