package ru.kraiush.threads.BJS2_25570;

import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@NoArgsConstructor
public class DeliveryService extends Thread {

    private Order order;

    private List<PromoCode> listPromoCodes;

    public DeliveryService(Order order, List<PromoCode> listPromoCodes) {
        this.order = order;
        this.listPromoCodes = listPromoCodes;
    }

    private final List<Order> listprocessedOrders = new ArrayList<>();

    @Override
    public void run() {
        processOrder(order, listPromoCodes);
    }

    void processOrder(Order order, List<PromoCode> listPromoCodes) {

        synchronized (listPromoCodes) {
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
            listprocessedOrders.add(order);
            System.out.println(" <<<The order has been processed!>>>\n\n");
        }
    }

    void addPromoCode(List<PromoCode> listPromoCodes, PromoCode promoCode) {
        synchronized (listPromoCodes) {
            listPromoCodes.add(promoCode);
        }
    }
}
