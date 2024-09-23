package ru.kraiush.threads.BJS2_25570;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

@NoArgsConstructor
@AllArgsConstructor
public class DeliveryService implements Runnable {

    private CopyOnWriteArrayList<Order> listOrders = new CopyOnWriteArrayList<>();
    private Order order;
    private List<PromoCode> listPromoCodes;
    private Lock lock;

    @Override
    public void run() {
        processOrder(order, listPromoCodes);
    }

    void processOrder(Order order, List<PromoCode> listPromoCodes) {
        lock.lock();
        try {
            BigDecimal totalPrice = order.getTotalPrice(order.getListProducts());
            System.out.println("Order: " + order);
            System.out.println(" totalPrice: " + totalPrice);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }

            List<PromoCode> list = listPromoCodes.stream()
                    .filter(w -> !w.isUsed())
                    .filter(o -> order.getTotalPrice(order.getListProducts()).compareTo(o.getMinimumOrderValue()) > 0)
                    .filter(t -> t.getExpirationDate().before(new Date()))
                    .toList();

            if (!list.isEmpty()) {
                PromoCode orderPromoCode = list.stream().max(Comparator.comparing(PromoCode::getDiscount)).get();
                orderPromoCode.setUsed(true);
                System.out.println("selected the orderPromoCode: \n" + orderPromoCode);
                BigDecimal priceWithDiscont = order.applyDiscount(totalPrice, orderPromoCode);
                System.out.println(" price With Discont: " + priceWithDiscont);
            } else {
                System.out.println(" >>>No suitable promoCode was sfound!<<<");
            }
            listOrders.add(order);
            System.out.println(" <<<The order has been processed!>>>\n");
        } finally {
            lock.unlock();
        }
    }

    void addPromoCode(List<PromoCode> listPromoCodes, PromoCode promoCode) {
        listPromoCodes.add(promoCode);
    }
}
