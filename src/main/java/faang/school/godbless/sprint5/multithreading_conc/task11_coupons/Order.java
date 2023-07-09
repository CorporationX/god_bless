package faang.school.godbless.sprint5.multithreading_conc.task11_coupons;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Order {

    private final List<Product> products = new ArrayList<>();

    private int sumPrice;

    public void addProduct(Product product) {
        products.add(product);
        sumPrice += product.getPrice();
    }

    public void applyDiscount(double discount) {
        products.stream()
                .peek(p -> p.setPrice((int) (p.getPrice() * (1 - discount))));
    }

    @Override
    public String toString() {
        return "Заказ{" +
                "products=" + products +
                ", sumPrice=" + sumPrice +
                '}';
    }
}
