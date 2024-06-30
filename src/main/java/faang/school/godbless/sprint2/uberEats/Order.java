package faang.school.godbless.sprint2.uberEats;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Evgenii Malkov
 */
@Getter
@Slf4j
public class Order {
    private final String id;
    private final List<Product> products = new CopyOnWriteArrayList<>();
    private int discount = 0;
    private double totalPrice = 0;
    private String code;

    public Order(String id, List<Product> products) {
        this.id = id;
        this.products.addAll(products);
    }

    public boolean applyDiscount(int discount, String code) {
        try {
            this.discount = discount;
            this.code = code;
            return true;
        } catch (Exception e) {
            this.discount = 0;
            this.code = null;
            log.error("Не удалось применить скидку {} к товарам заказа {}", discount, id);
            return false;
        }
    }

    public double getTotalPrice() {
        this.totalPrice = products.stream().mapToDouble(Product::getPrice).sum();
        if (this.discount > 0) {
            this.totalPrice = this.totalPrice * (100 - this.discount) / 100;
        }
        return this.totalPrice;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Order.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("Продуктов=" + products.size())
                .add("без скидки=" + products.stream().mapToDouble(Product::getPrice).sum())
                .add("скидка=" + discount + "%")
                .add("с скидкой=" + totalPrice)
                .add("код=" + code)
                .toString();
    }
}
