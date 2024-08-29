package faang.school.godbless.BJS2_25460;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        DeliveryService service = new DeliveryService();
        getPromoCodes().forEach(service::putPromoCode);

        ExecutorService executor = Executors.newCachedThreadPool();
        IntStream.rangeClosed(1, 100).forEach(i -> executor.execute(() -> {
                    Order order = new Order(i);
                    IntStream.range(0, 5).forEach(j -> order.addProduct(getProduct()));
                    List<String> promoCodes = List.of(getPromoCode().getCode(), getPromoCode().getCode(), getPromoCode().getCode());
                    service.processOrder(order, promoCodes);
                }));

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println(service.getPromoCodes());
        System.out.println(service.getOrders().size());
    }

    private static PromoCode getPromoCode() {
        List<PromoCode> promoCodes = getPromoCodes();
        int index = RANDOM.nextInt(promoCodes.size());
        return promoCodes.get(index);
    }

    private static Product getProduct() {
        List<Product> products = getProducts();
        int index = RANDOM.nextInt(products.size());
        return products.get(index);
    }

    private static List<PromoCode> getPromoCodes() {
        return List.of(
                new PromoCode("PROMO1", 6.0, LocalDate.now().minusDays(2), 10.0, false),
                new PromoCode("PROMO2", 7.0, LocalDate.now().plusDays(4), 20.0, false),
                new PromoCode("PROMO3", 8.0, LocalDate.now().plusDays(6), 30.0, false),
                new PromoCode("PROMO4", 9.0, LocalDate.now().minusDays(8), 40.0, false),
                new PromoCode("PROMO5", 10.0, LocalDate.now().plusDays(10), 50.0, false),
                new PromoCode("PROMO6", 11.0, LocalDate.now().minusDays(12), 60.0, false),
                new PromoCode("PROMO7", 12.0, LocalDate.now().plusDays(14), 70.0, false),
                new PromoCode("PROMO8", 13.0, LocalDate.now().plusDays(16), 80.0, true),
                new PromoCode("PROMO9", 14.0, LocalDate.now().plusDays(18), 90.0, false),
                new PromoCode("PROMO10", 15.0, LocalDate.now().plusDays(20), 100.0, true),
                new PromoCode("PROMO11", 16.0, LocalDate.now().minusDays(22), 110.0, false),
                new PromoCode("PROMO12", 17.0, LocalDate.now().plusDays(24), 120.0, false),
                new PromoCode("PROMO13", 18.0, LocalDate.now().plusDays(26), 130.0, false),
                new PromoCode("PROMO14", 19.0, LocalDate.now().plusDays(28), 140.0, true),
                new PromoCode("PROMO15", 20.0, LocalDate.now().minusDays(30), 150.0, false),
                new PromoCode("PROMO16", 21.0, LocalDate.now().plusDays(32), 160.0, true),
                new PromoCode("PROMO17", 22.0, LocalDate.now().plusDays(34), 170.0, false),
                new PromoCode("PROMO18", 23.0, LocalDate.now().plusDays(36), 180.0, false),
                new PromoCode("PROMO19", 24.0, LocalDate.now().minusDays(38), 190.0, false),
                new PromoCode("PROMO20", 25.0, LocalDate.now().plusDays(40), 200.0, false)
        );
    }

    private static List<Product> getProducts() {
        return List.of(
                new Product("Product1", 10.0),
                new Product("Product2", 12.5),
                new Product("Product3", 15.0),
                new Product("Product4", 17.5),
                new Product("Product5", 20.0),
                new Product("Product6", 22.5),
                new Product("Product7", 25.0),
                new Product("Product8", 27.5),
                new Product("Product9", 30.0),
                new Product("Product10", 32.5),
                new Product("Product11", 35.0),
                new Product("Product12", 37.5),
                new Product("Product13", 40.0),
                new Product("Product14", 42.5),
                new Product("Product15", 45.0),
                new Product("Product16", 47.5),
                new Product("Product17", 50.0),
                new Product("Product18", 52.5),
                new Product("Product19", 55.0),
                new Product("Product20", 57.5)
        );
    }
}
