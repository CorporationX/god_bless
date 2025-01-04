package school.faang.task_52223;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        DeliveryService deliveryService = initProCode();

        List<Product> productsOne = List.of(
                new Product("Product 1", 600),
                new Product("Product 2", 500),
                new Product("Product 3", 300));

        List<Product> productsTwo = List.of(
                new Product("Product 4", 200),
                new Product("Product 5", 400),
                new Product("Product 6", 100));

        Order orderOne = new Order();
        orderOne.getProducts().addAll(productsOne);

        Order orderTwo = new Order();
        orderTwo.getProducts().addAll(productsTwo);

        List<PromoCode> promoCodesOne = List.of(
                new PromoCode("PROMO10", 10,
                        LocalDate.of(2025, 12, 31), PromoCodeStatus.ACTIVE),
                new PromoCode("PROMO25", 25,
                        LocalDate.of(2023, 12, 25), PromoCodeStatus.ACTIVE),
                new PromoCode("PROMO30", 30,
                        LocalDate.of(2025, 1, 31), PromoCodeStatus.INVALID)
        );

        List<PromoCode> promoCodesTwo = List.of(
                new PromoCode("PROMO10", 10,
                        LocalDate.of(2025, 12, 31), PromoCodeStatus.ACTIVE),
                new PromoCode("PROMO7", 7,
                        LocalDate.of(2025, 11, 30), PromoCodeStatus.ACTIVE),
                new PromoCode("PROMO30", 30,
                        LocalDate.of(2025, 1, 31), PromoCodeStatus.INVALID),
                new PromoCode("PROMO25", 25,
                        LocalDate.of(2023, 12, 25), PromoCodeStatus.ACTIVE)
        );

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(() -> deliveryService.processOrder(orderOne, promoCodesOne));
        executorService.submit(() -> deliveryService.processOrder(orderTwo, promoCodesTwo));

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            log.info("Принудительное завершение потока" + e);
        }

    }

    public static DeliveryService initProCode() {
        DeliveryService deliveryService = new DeliveryService();

        deliveryService.addPromoCode(new PromoCode("PROMO10", 10,
                LocalDate.of(2025, 12, 31), PromoCodeStatus.ACTIVE));
        deliveryService.addPromoCode(new PromoCode("PROMO20", 20,
                LocalDate.of(2025, 11, 30), PromoCodeStatus.ACTIVE));
        deliveryService.addPromoCode(new PromoCode("PROMO25", 25,
                LocalDate.of(2025, 12, 25), PromoCodeStatus.ACTIVE));
        deliveryService.addPromoCode(new PromoCode("PROMO35", 35,
                LocalDate.of(2025, 11, 30), PromoCodeStatus.ACTIVE));
        deliveryService.addPromoCode(new PromoCode("PROMO17", 17,
                LocalDate.of(2025, 12, 25), PromoCodeStatus.ACTIVE));
        deliveryService.addPromoCode(new PromoCode("PROMO7", 7,
                LocalDate.of(2025, 11, 30), PromoCodeStatus.ACTIVE));

        return deliveryService;
    }

}
