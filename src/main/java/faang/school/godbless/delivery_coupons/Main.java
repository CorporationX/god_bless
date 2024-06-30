package faang.school.godbless.delivery_coupons;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    private static final int ORDER_NUM = 6;
    private static final int THREAD_NUM = 8;
    private static final int PROMOCODE_NUM = 10;
    private static final int TIME_LIMIT_IN_SECONDS = 10;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUM);

        DeliveryService deliveryService = getDeliveryService();
        List<String> allPromoCodeId = getPromoCodeIdList();
        List<Order> orderList = getOrderList();

        IntStream.range(0, ORDER_NUM).forEach(i -> {
            List<String> orderPromoCodeList =
                    allPromoCodeId.subList(0, ThreadLocalRandom.current().nextInt(0, PROMOCODE_NUM));
            executorService.execute(() -> deliveryService.processOrder(orderList.get(i), orderPromoCodeList));
        });

        executorService.shutdown();

        try {
            executorService.awaitTermination(TIME_LIMIT_IN_SECONDS, TimeUnit.SECONDS);
            System.out.println(executorService);
            System.out.println(deliveryService.getActivePromoCodeMap());
            System.out.println(deliveryService.getProcessedOrders());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static DeliveryService getDeliveryService() {
        DeliveryService deliveryServiceToReturn = new DeliveryService();

        List<PromoCode> promoCodeList = getPromoCodes();
        promoCodeList.forEach(deliveryServiceToReturn::addPromoCode);

        return deliveryServiceToReturn;
    }

    private static List<Order> getOrderList() {
        List<Order> orderListToReturn = new ArrayList<>();

        orderListToReturn.add(new Order(List.of(new Product("1", 100))));
        orderListToReturn.add(new Order(List.of(new Product("2", 200))));
        orderListToReturn.add(new Order(List.of(new Product("3", 300))));
        orderListToReturn.add(new Order(List.of(new Product("4", 400))));
        orderListToReturn.add(new Order(List.of(new Product("5", 500))));
        orderListToReturn.add(new Order(List.of(new Product("6", 600))));

        return orderListToReturn;
    }

    private static List<PromoCode> getPromoCodes() {
        return List.of(
                new PromoCode("1", 1, LocalDateTime.now().plusDays(1), 10, false),
                new PromoCode("2", 2, LocalDateTime.now().plusDays(1), 100, false),
                new PromoCode("3", 3, LocalDateTime.now().plusDays(1), 200, false),
                new PromoCode("4", 9, LocalDateTime.now().plusDays(1), 200, false),
                new PromoCode("5", 4, LocalDateTime.now().plusDays(1), 100, true),
                new PromoCode("6", 10, LocalDateTime.now().plusDays(1), 200, false),
                new PromoCode("7", 5, LocalDateTime.now().plusDays(1), 300, false),
                new PromoCode("8", 6, LocalDateTime.now().plusDays(1), 100, false),
                new PromoCode("9", 7, LocalDateTime.now().plusDays(1), 100, true),
                new PromoCode("0", 8, LocalDateTime.now().plusDays(1), 400, false)
        );
    }

    private static List<String> getPromoCodeIdList() {
        return List.of(
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"
        );
    }
}
