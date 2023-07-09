package faang.school.godbless.sprint5.multithreading_conc.task11_coupons;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

@Getter
public class PromoCode implements Comparable<PromoCode> {

    private final String code;

    private final double discount;

    private final LocalDateTime expirationDate;

    private final int minimumOrderValue;

    private boolean isUsed;

    private final ReentrantLock lock = new ReentrantLock();

    public PromoCode(String code, double discount, LocalDateTime expirationDate, int minimumOrderValue, boolean isUsed) {
        this.code = code;
        this.discount = discount;
        this.expirationDate = expirationDate;
        this.minimumOrderValue = minimumOrderValue;
        this.isUsed = isUsed;
    }

    public boolean isValidForOrder(Order order) {
        if (expirationDate.isBefore(LocalDateTime.now())) {
            System.out.println("Срок действия промокода истек!");
            return false;
        }
        int sumOrder = order.getSumPrice();
        if (sumOrder < minimumOrderValue) {
            System.out.println("Сумма заказа меньше суммы для получения скидки!" + " Заказ " + order.getProducts().toString() + " сумма " + sumOrder + " < " + minimumOrderValue);
            return false;
        }

        if (isUsed) {
            System.out.println("Промокод уже был использован!");
            return false;
        }
        return true;
    }

    public void setUsed(boolean used) {
        lock.lock();
        try {
            isUsed = used;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int compareTo(PromoCode o) {
        double result = this.getDiscount() - o.getDiscount();
        if (result > 0) {
            return -1;
        } else if (result < 0) {
            return 1;
        } else {
            return 0;
        }
    }

}
