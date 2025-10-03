package school.faang.m1.concurrency.promo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class DeliveryService {
    private final ConcurrentHashMap<String, PromoCode> promoCodesMap = new ConcurrentHashMap<>();
    private final List<Order> processedOrders = Collections.synchronizedList(new ArrayList<>());

    public void addPromoCode(PromoCode promoCode) {
        PromoCode prev = promoCodesMap.putIfAbsent(promoCode.getCode(), promoCode);
        if (prev != null) {
            throw new IllegalArgumentException("Duplicate promo code: " + promoCode.getCode());
        }
    }

    public Optional<PromoCode> processOrder(Order order, List<String> promoCodes) {
        List<String> unique = promoCodes.stream().filter(Objects::nonNull).distinct().toList();

        List<PromoCode> candidates = new ArrayList<>();
        for (String c : unique) {
            PromoCode pc = promoCodesMap.get(c);
            if (pc != null && pc.isValidForOrder(order)) {
                candidates.add(pc);
            }
        }

        candidates.sort(Comparator.comparing(PromoCode::getDiscount).reversed());

        Optional<PromoCode> applied = Optional.empty();
        for (PromoCode pc : candidates) {
            if (pc.markAsUsed()) {
                order.applyDiscount(pc.getDiscount());
                promoCodesMap.remove(pc.getCode(), pc);
                applied = Optional.of(pc);
                break;
            }
        }

        processedOrders.add(order);
        return applied;
    }

    public int activePromoCount() {
        return promoCodesMap.size();
    }

    public List<Order> getProcessedOrdersSnapshot() {
        synchronized (processedOrders) {
            return List.copyOf(processedOrders);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DeliveryService service = new DeliveryService();

        service.addPromoCode(new PromoCode("WELCOME10", new BigDecimal("10.0"),
                LocalDate.now().plusDays(5), new BigDecimal("10")));
        service.addPromoCode(new PromoCode("SUPER20", new BigDecimal("20"),
                LocalDate.now().plusDays(1), new BigDecimal("20")));
        service.addPromoCode(new PromoCode("MEGA30", new BigDecimal("30"),
                LocalDate.now().plusDays(1), new BigDecimal("40")));
        service.addPromoCode(new PromoCode("ONCE50", new BigDecimal("50"),
                LocalDate.now().plusDays(1), new BigDecimal("15")));

        List<Product> menu = List.of(
                new Product("Burger", new BigDecimal("12.0")),
                new Product("Fries", new BigDecimal("5.0")),
                new Product("Soda", new BigDecimal("3.0")),
                new Product("Pizza", new BigDecimal("18.0")),
                new Product("Salad", new BigDecimal("9.5"))
        );

        Order o1 = new Order(List.of(menu.get(0), menu.get(1))); // $17
        Order o2 = new Order(List.of(menu.get(3))); // $18
        Order o3 = new Order(List.of(menu.get(3), menu.get(2))); // $21
        Order o4 = new Order(List.of(menu.get(0), menu.get(3))); // $30
        Order o5 = new Order(List.of(menu.get(4), menu.get(2))); // $12.5

        List<String> codes1 = List.of("MEGA30", "WELCOME10"); // подходит, 30% лучше 10%
        List<String> codes2 = List.of("ONCE50", "SUPER20"); // 50% лучший, но однократный
        List<String> codes3 = List.of("ONCE50", "MEGA30", "WELCOME10"); // попытается урвать 50%
        List<String> codes4 = List.of("SUPER20"); // 20%
        List<String> codes5 = List.of("WELCOME10"); // 10%

        System.out.println("\n=== Results ===");
        List<Callable<String>> tasks = List.of(
                () -> simulateClient(service, "C1", o1, codes1),
                () -> simulateClient(service, "C2", o2, codes2),
                () -> simulateClient(service, "C3", o3, codes3),
                () -> simulateClient(service, "C4", o4, codes4),
                () -> simulateClient(service, "C5", o5, codes5)
        );

        ExecutorService pool = Executors.newFixedThreadPool(5);
        List<Future<String>> results = pool.invokeAll(tasks);
        pool.shutdown();
        Boolean ignored = pool.awaitTermination(10, TimeUnit.SECONDS);

        for (Future<String> f : results) {
            try {
                System.out.println(f.get());
            } catch (ExecutionException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        System.out.println("Active promo left: " + service.activePromoCount());


        // This is just summary demo, to use  getProcessedOrdersSnapshot
        List<Order> snap = service.getProcessedOrdersSnapshot();
        BigDecimal gross = snap.stream().map(Order::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, RoundingMode.HALF_UP);
        BigDecimal net = snap.stream().map(Order::getPayableAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, RoundingMode.HALF_UP);
        BigDecimal saved = gross.subtract(net).setScale(2, RoundingMode.HALF_UP);
        BigDecimal avgDisc = snap.isEmpty() ? new BigDecimal("0.00") :
                snap.stream().map(Order::getAppliedDiscountPercent).map(AtomicReference::get)
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
                        .divide(new BigDecimal(snap.size()), 2, RoundingMode.HALF_UP);

        Map<String, Long> byDiscount = snap.stream()
                .collect(Collectors.groupingBy(
                        o -> o.getAppliedDiscountPercent().get().toPlainString() + "%", Collectors.counting()
                ));

        System.out.println("\n=== Summary ===");
        System.out.println("Orders: " + snap.size());
        System.out.println("Gross: $" + gross.toPlainString()
                + "  Net: $" + net.toPlainString()
                + "  Saved: $" + saved.toPlainString());
        System.out.println("Average discount: " + avgDisc.toPlainString() + "%");
        System.out.println("By discount: " + byDiscount);

    }


    /*
        рандомная задержка для имитации гонки
     */
    private static String simulateClient(DeliveryService service, String clientId, Order order, List<String> codes) {
        String thread = Thread.currentThread().getName();
        String items = order.getProducts().stream()
                .map(p -> p.name() + " $" + p.price().toPlainString())
                .collect(Collectors.joining(", "));
        String codesStr = String.join(", ", codes);


        System.out.println("[" + thread + "] " + clientId + ": placing order: items=[" + items +
                "], total=$" + order.getTotalPrice().toPlainString() + ", codes=[" + codesStr + "]");
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(25, 250));
        } catch (InterruptedException ignored) {
            // ignored
        }
        Optional<PromoCode> applied = service.processOrder(order, codes);
        String appliedStr = applied.map(pc -> pc.getCode() + "(" + pc.getDiscount() + "%)").orElse("<none>");
        return "%s: total=$%.2f, discount=%s, pay=$%.2f".formatted(
                clientId, order.getTotalPrice(), appliedStr, order.getPayableAmount());
    }

}

