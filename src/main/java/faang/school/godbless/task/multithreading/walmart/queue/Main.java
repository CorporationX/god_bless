package faang.school.godbless.task.multithreading.walmart.queue;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    private static final Configuration config = new Configuration();
    private static final List<Customer> customers = config.getCustomers();
    private static final List<CashierThread> cashierThreads = getCashiersThreads();

    public static void main(String[] args) {
        startThreads();
        joinThreads();
        log.info("{} cashiers served {} customers", config.getNumberOfCashiers(), config.getNumberOfCustomers());
        log.info("Total sum: {}$", CashierThread.getTotalSum());
    }

    private static void startThreads() {
        cashierThreads.forEach(Thread::start);
    }

    private static void joinThreads() {
        cashierThreads.forEach(cashierThread -> {
            try {
                cashierThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static List<CashierThread> getCashiersThreads() {
        return customers
                .stream()
                .map(customer -> new CashierThread(config.getCashierId(), customer))
                .toList();
    }
}
