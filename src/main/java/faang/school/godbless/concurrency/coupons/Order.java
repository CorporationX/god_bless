package faang.school.godbless.concurrency.coupons;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Order {
    private final int id;
    private final Map<Product, AtomicInteger> productBasket = new HashMap<>();
    private int discount;

    public Order(int id) {
        this.id = id;
        discount = 0;
    }

    public void addProductToBasket(Product product) {
        productBasket.computeIfAbsent(product, key -> new AtomicInteger(1)).incrementAndGet();
    }

    public synchronized void applyDiscount(Promocode promocode) {
        if (!promocode.isValidForOrder(this)) {
            return;
        }

        promocode.usePromocode();
        discount = promocode.getDiscount();
    }

    public int getTotalPrice(boolean withDiscount) {
        var totalPriceWithoutDiscount = productBasket.entrySet().stream()
                .map(entry -> entry.getValue().get() * entry.getKey().price())
                .reduce(0, Integer::sum);
        var priceRatioWithDiscount = withDiscount ? 1 - discount / 100f : 1;

        return Math.round(totalPriceWithoutDiscount * priceRatioWithDiscount);
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", productBasket=" + productBasket +
                ", discount=" + discount +
                '}';
    }
}
