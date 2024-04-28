package faang.school.godbless.delivery_coupons;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Data
@Slf4j
public class Order {
    private static int startId = 0;
    private int id;
    private List<Product> products;
    private double totalPrice;
    private ReentrantLock reentrantLock;

    public Order(List<Product> products) {
        this.id = startId++;
        this.products = products;
        this.totalPrice = getTotalBalance();
        this.reentrantLock = new ReentrantLock();
    }

    public boolean applyDiscount(Promocode promocode) {
        reentrantLock.lock();
        promocode.getReentrantLock().lock();
        try {
            if (!promocode.isValidForOrder(totalPrice)) {
                log.error("Discount cannot be applied");
                return false;
            }

            promocode.usePromocode();
            totalPrice = totalPrice * (100 - promocode.getDiscountPercentage());
        } finally {
            promocode.getReentrantLock().unlock();
            reentrantLock.unlock();
        }

        return true;
    }

    private double getTotalBalance() {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
}
