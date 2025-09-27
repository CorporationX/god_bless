package school.faang.discount;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {

        DeliveryService service = new DeliveryService();

        PromoCode promo1 = new PromoCode(101, 10, LocalDate.now().plusDays(5), 5.0);
        PromoCode promo2 = new PromoCode(102, 15, LocalDate.now().plusDays(3), 10.0);
        PromoCode promo3 = new PromoCode(103, 20, LocalDate.now().plusDays(7), 8.0);

        service.addPromoCode(promo1);
        service.addPromoCode(promo2);
        service.addPromoCode(promo3);

        Product burger = new Product("Burger", 6.0);
        Product fries = new Product("Fries", 3.0);
        Product soda = new Product("Soda", 2.0);

        Order order1 = new Order(List.of(burger, fries));
        Order order2 = new Order(List.of(fries, soda));
        Order order3 = new Order(List.of(burger, soda));

        List<Order> orders = List.of(order1, order2, order3);
        List<List<PromoCode>> orderPromos = List.of(
                List.of(promo1, promo2),
                List.of(promo2, promo3),
                List.of(promo1, promo3)
        );

        CompletableFuture<?>[] futures = new CompletableFuture[orders.size()];

        for (int i = 0; i < orders.size(); i++) {
            final int index = i;
            futures[i] = CompletableFuture.runAsync(() -> {
                service.processOrder(orders.get(index), orderPromos.get(index));
                System.out.println("Processed order " + (index + 1) +
                        ", total: $" + orders.get(index).getTotalPrice());
            });
        }

        CompletableFuture.allOf(futures).join();
        System.out.println("\nAll orders processed. Total orders: " + service.getProcessedOrders().size());
        System.out.println("Remaining promo codes: " + service.getPromoCodes().size());

    }
}
