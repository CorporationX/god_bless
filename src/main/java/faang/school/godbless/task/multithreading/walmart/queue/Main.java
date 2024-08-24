package faang.school.godbless.task.multithreading.walmart.queue;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private final static int NUMBER_OF_CUSTOMERS = 17;
    private final static int MAX_ITEM_PER_CUSTOMER = 5;
    private final static int MAX_ITEM_COST = 300;
    private final static int NUMBER_OF_CASHIERS = 4;
    private final static int THREAD_POOL_SIZE = NUMBER_OF_CUSTOMERS;

    private static final ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    private static final Random random = new Random();
    private static final List<CompletableFuture<Integer>> futures = new ArrayList<>();
    private static List<CashierThread> cashiers;
    private static List<Customer> customers;


    public static void main(String[] args) {
        initialDefaults();
        futures.addAll(getFutures());
        int totalSum = calculateTotalSum();
        log.info("{} cashiers served {} customers", NUMBER_OF_CASHIERS, NUMBER_OF_CUSTOMERS);
        log.info("Total sum: {}$", totalSum);
        executor.shutdown();
    }

    public static void initialDefaults() {
        customers = getCustomers();
        cashiers = getCashiersThreads();
    }

    private static int calculateTotalSum() {
        try {
            return CompletableFuture
                    .allOf(futures.toArray(new CompletableFuture[0]))
                    .thenApply(v -> sumOfFuturesValues())
                    .get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private static int sumOfFuturesValues() {
        return futures
                .stream()
                .map(CompletableFuture::join)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static List<CompletableFuture<Integer>> getFutures() {
        return cashiers
                .stream()
                .map(cashierThread -> CompletableFuture
                        .supplyAsync(() -> serveClient(cashierThread), executor))
                .toList();
    }

    private static int serveClient(CashierThread cashierThread) {
        cashierThread.run();
        return cashierThread.getSum();
    }


    private static List<CashierThread> getCashiersThreads() {
        return customers
                .stream()
                .map(customer -> new CashierThread(getCashierId(), customer))
                .toList();
    }

    private static long getCashierId() {
        return random.nextInt(NUMBER_OF_CASHIERS - 1) + 1;
    }

    private static List<Customer> getCustomers() {
        return IntStream
                .rangeClosed(1, NUMBER_OF_CUSTOMERS)
                .mapToObj(i -> new Customer("Customer " + i, getItems()))
                .toList();
    }

    private static List<CustomerItem> getItems() {
        return IntStream
                .rangeClosed(1, getNumberOfItem())
                .mapToObj(i -> new CustomerItem(getItemCost(), "Item " + i))
                .toList();
    }

    private static int getItemCost() {
        return random.nextInt(MAX_ITEM_COST - 1) + 1;
    }

    private static int getNumberOfItem() {
        return random.nextInt(MAX_ITEM_PER_CUSTOMER - 1) + 1;
    }
}
