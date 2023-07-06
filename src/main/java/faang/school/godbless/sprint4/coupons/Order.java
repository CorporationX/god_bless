package faang.school.godbless.sprint4.coupons;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Order {
    private List<Product> products = new ArrayList<>();
    private int totalPrice = 0;
    public void applyDiscount(double discount) {
      double discountPrice = getTotalPrice() * (1 - discount);
      products.clear();
      products.add(new Product("Discount", discountPrice));
    }
    public int getTotalPrice() {
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
    public void addProduct(Product product) {
        products.add(product);
    }
}
