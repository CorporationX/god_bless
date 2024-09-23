package ru.kraiush.threads.BJS2_25570;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class AppPromoCodeDeliveryUberEats {

    public static void main(String[] args) {

        System.out.print(String.join("", Collections.nCopies(80, "-")));
        System.out.println();

        final CopyOnWriteArrayList<PromoCode> listPromoCodes = new CopyOnWriteArrayList<>();
        final List<Order> listOrders = new ArrayList<>();
//        final CopyOnWriteArrayList<Order> listOrders = new CopyOnWriteArrayList<>();
        for (int i = 1; i < 21; i++) {
            listPromoCodes.add(
                    new PromoCode(getPromoCode(),
                            ThreadLocalRandom.current().nextInt(1, 11),
                            new Date(System.currentTimeMillis() + ThreadLocalRandom.current().nextInt(1000, 5000)),
                            randomBigDecimal(new BigDecimal(750), new BigDecimal(2000)),
                            false
                    )
            );
        }

        for (int q = 1; q < 6; q++) {
            List<Product> listProducts = new ArrayList<>();
            int numberGoods = ThreadLocalRandom.current().nextInt(1, 6);
            for (int j = 1; j <= numberGoods; j++) {
                int good = ThreadLocalRandom.current().nextInt(1, 10);
                listProducts.add(new Product(getGoodsType(good), randomBigDecimal(new BigDecimal(100), new BigDecimal(1000))));
            }
            listOrders.add(new Order(listProducts));
        }

        DeliveryService service = new DeliveryService();
        PromoCode promoCode = new PromoCode("New",
                ThreadLocalRandom.current().nextInt(1, 10),
                new Date(System.currentTimeMillis() + ThreadLocalRandom.current().nextInt(200, 7000)),
                randomBigDecimal(new BigDecimal(500), new BigDecimal(2000)),
                false);
        service.addPromoCode(listPromoCodes, promoCode);

        for (Order listOrder : listOrders) {
            Thread task = new DeliveryService(listOrder, listPromoCodes);
            task.start();
        }
    }

    public static String getPromoCode() {
        String[] promoCodeTypes = {"Super", "Suitable", "The best", "Fucking", "Scam", "Bombastic", "Attractive", "Madness", "Deception"};
        return promoCodeTypes[new Random().nextInt(promoCodeTypes.length)];
    }

    public static String getGoodsType(int type) {
        String[] goodsNames = {"shovel", "hammer", "rake", "pliers", "scissors", "glue", "saw", "file", "hacksaw", "sickle"};
        return goodsNames[type];
    }

    public static BigDecimal randomBigDecimal(BigDecimal min, BigDecimal max) {
        BigDecimal randomBigDecimal = min.add(new BigDecimal(Math.random()).multiply(max.subtract(min)));
        return randomBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
