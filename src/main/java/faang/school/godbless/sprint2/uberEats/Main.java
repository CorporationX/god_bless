package faang.school.godbless.sprint2.uberEats;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Evgenii Malkov
 */
@Slf4j
public class Main {
    private static final String PROMO_PREFIX = "-Summer2024";
    private static final int PRODUCT_COUNT = 20;
    private static final int PROMOCODES_COUNT = 5;
    private static final int ORDER_COUNT = 10;
    private static final int PROMOCODES_IN_ORDER_COUNT = 3;
    private static final int MIN_CODES_IN_ORDER_COUNT = 2;
    private static final int POOL_SIZE = 8;

    public static void main(String[] args) {
        ExecutorService executors = Executors.newFixedThreadPool(POOL_SIZE);
        Map<String, PromoCode> activeCodes = generatePromocodes();
        DeliveryService service = new DeliveryService(activeCodes);
        List<Product> products = generateProducts();

        log.info("Активные коды: {}", activeCodes.keySet());
        for (int i = 0; i <= ORDER_COUNT; i++) {
            Order order = new Order("ORDER" + i, randomProductsToOrder(products));
            List<String> codes = randomCodesToOrder();
            executors.submit(() -> service.processOrder(order, codes));
        }

        executors.shutdown();
        try {
            if (!executors.awaitTermination(20, TimeUnit.SECONDS)) {
                executors.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            executors.shutdownNow();
            Thread.currentThread().interrupt();
        }

        log.info("Конечный список заказов: ");
        service.getOrders().forEach((order) -> log.info(order.toString()));
    }

    public static Map<String, PromoCode> generatePromocodes() {
        Random random = new Random();
        List<PromoCode> codes = IntStream.range(0, PROMOCODES_COUNT)
                .mapToObj((i) -> new PromoCode(i + PROMO_PREFIX,
                        random.nextInt(5, 50),
                        System.currentTimeMillis() + random.nextLong(30) * 24 * 60 * 60 * 1000,
                        random.nextInt(1000, 5000))).toList();

        return codes.stream()
                .collect(Collectors.toMap(PromoCode::getCode, (code) -> code));
    }

    public static List<Product> randomProductsToOrder(List<Product> products) {
        Random random = new Random();
        int size = random.nextInt(1, 10);
        List<Product> productsInOrder = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int randomProductIndex = random.nextInt(0, PRODUCT_COUNT);
            productsInOrder.add(products.get(randomProductIndex));
        }
        return productsInOrder;
    }

    public static List<String> randomCodesToOrder() {
        Random random = new Random();
        int codesCount = random.nextInt(MIN_CODES_IN_ORDER_COUNT, PROMOCODES_IN_ORDER_COUNT);
        Set<String> codes = new HashSet<>();
        for (int i = 0; i < codesCount; i++) {
            codes.add(random.nextInt(0, PROMOCODES_COUNT) + PROMO_PREFIX);
        }
        return codes.stream().toList();
    }

    public static List<Product> generateProducts() {
        Random random = new Random();
        return IntStream.range(0, PRODUCT_COUNT)
                .mapToObj((i) -> new Product(i + "Product", random.nextInt(1, 10_000))).toList();
    }
}
