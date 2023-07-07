package faang.school.godbless.sprint4.coupons;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DeliveryService deliveryService = new DeliveryService();

        PromoCode promoCode1 = new PromoCode("ABC123", 0.1, LocalDate.now().plusDays(7), 50, false);
        PromoCode promoCode2 = new PromoCode("DEF456", 0.2, LocalDate.now().plusDays(30), 100, false);

        deliveryService.addActivePromoCode(promoCode1);
        deliveryService.addActivePromoCode(promoCode2);

        List<String> promoCodes = Arrays.asList(promoCode1.getCode(), promoCode2.getCode());

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                Order order = new Order();
                Random random = new Random();
                for (int j = 0; j < 5; j++) {
                    order.addProduct(new Product("Product " + j, 10 + random.nextInt(100)));
                }
                List<String> currentPromoCodes = new ArrayList<>(promoCodes);
                if (random.nextDouble() < 0.5) {
                    currentPromoCodes.remove(promoCode1.getCode());
                }
                else {
                    currentPromoCodes.remove(promoCode2.getCode());
                }
                deliveryService.processOrder(order, currentPromoCodes);
            });
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        List<Order> processedOrders = deliveryService.getProcessedOrders();

        System.out.println("Total processed orders: " + processedOrders.size());

        double totalSales = processedOrders.stream().mapToDouble(Order::getTotalPrice).sum();
        double discountedSales = processedOrders.stream().filter(order -> order.getTotalPrice() < 250).mapToDouble(Order::getTotalPrice).sum();

        System.out.println("Total sales: " + totalSales);
        System.out.println("Discounted sales: " + discountedSales);
    }
}
