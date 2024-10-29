package school.faangSprint4.t25;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DeliveryService deliveryService = new DeliveryService();

        deliveryService.addPromoCode(new PromoCode("SUMMER10", 10.0, LocalDate.now().plusDays(30), 1000.0));
        deliveryService.addPromoCode(new PromoCode("WINTER20", 20.0, LocalDate.now().plusDays(30), 2000.0));
        deliveryService.addPromoCode(new PromoCode("SPRING15", 15.0, LocalDate.now().plusDays(30), 1500.0));

        Runnable orderProcessor = () -> {
            List<Product> products = Arrays.asList(
                    new Product("Laptop", 1500.0),
                    new Product("Phone", 800.0),
                    new Product("Tablet", 600.0));

            Order order = new Order(products);
            List<String> promoCodes = Arrays.asList("SUMMER10", "WINTER20");
            deliveryService.processOrder(order, promoCodes);
            System.out.println("Order processed by thread: " + Thread.currentThread().getName());
        };

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(orderProcessor, "Customer-" + i);
            threads.add(thread);
            thread.start();
        }

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread interrupted: " + e.getMessage());
            }
        });
    }
}