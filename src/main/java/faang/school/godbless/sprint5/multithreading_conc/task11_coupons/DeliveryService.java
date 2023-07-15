package faang.school.godbless.sprint5.multithreading_conc.task11_coupons;

import java.util.Optional;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.locks.ReentrantLock;

public class DeliveryService {
    private final ConcurrentSkipListSet<PromoCode> promoCodes = new ConcurrentSkipListSet<>();
    private final ConcurrentLinkedQueue<Order> processOrders = new ConcurrentLinkedQueue<>();

    private final ReentrantLock lock = new ReentrantLock();

    public void addPromoCode(PromoCode promoCode) {
        promoCodes.add(promoCode);
    }

    public void processOrder(Order order) {
        PromoCode maxDiscount = findMaxDiscount(order);

        if (maxDiscount != null) {
            System.out.println("Применена скидка к заказу " + order + " в размере " + Math.ceil(maxDiscount.getDiscount() * 100) + "%");
            order.applyDiscount(maxDiscount.getDiscount());
            maxDiscount.setUsed(true);
        } else {
            System.out.println("Заказ " + order + " обработан без скидки. ");
        }
        processOrders.add(order);
    }

    private PromoCode findMaxDiscount(Order order) {
        lock.lock();
        try {
            Optional<PromoCode> max = promoCodes.stream()
                    .filter(promoCode -> promoCode.isValidForOrder(order))
                    .findFirst();
            if (max.isPresent()) {
                promoCodes.remove(max.get());
                return max.get();
            } else {
                return null;
            }
        } finally {
            lock.unlock();
        }
    }
}
