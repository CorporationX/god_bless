package faang.school.godbless.sprint4.coupons;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DeliveryService {
    private final List<PromoCode> activePromoCodes = new ArrayList<>();
    private final List<Order> processedOrders = new ArrayList<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void addActivePromoCode(PromoCode promoCode) {
        lock.writeLock().lock();
        try {
            activePromoCodes.add(promoCode);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public List<Order> getProcessedOrders() {
        lock.readLock().lock();
        try {
            return processedOrders;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void processOrder(Order order, List<String> promoCodes) {
        List<PromoCode> validPromoCodes = new ArrayList<>();
        double maxDiscount = 0;

        lock.readLock().lock();
        try {
            for (PromoCode promoCode : activePromoCodes) {
                if (promoCodes.contains(promoCode.getCode()) && promoCode.isValidForOrder(order)) {
                    validPromoCodes.add(promoCode);
                    if (promoCode.getDiscount() > maxDiscount) {
                        maxDiscount = promoCode.getDiscount();
                    }
                }
            }
        } finally {
            lock.readLock().unlock();
        }

        if (!validPromoCodes.isEmpty()) {
            order.applyDiscount(maxDiscount);
            validPromoCodes.get(0).markAsUsed();
            lock.writeLock().lock();
            try {
                activePromoCodes.remove(validPromoCodes.get(0));
            } finally {
                lock.writeLock().unlock();
            }
        }

        lock.writeLock().lock();
        try {
            processedOrders.add(order);
        } finally {
            lock.writeLock().unlock();
        }
    }
}
