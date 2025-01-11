package derschrank.sprint04.task25.bjstwo_51104.units;

import derschrank.sprint04.task25.bjstwo_51104.DeliveryService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

public record User(
        String name,
        List<String> myPromoCodes,
        Set<Order> myOrders
) {
    public User(String name) {
        this(name, new ArrayList<>(), ConcurrentHashMap.newKeySet());
    }

    public synchronized void addPromoCode(String code) {
        myPromoCodes.add(code);
    }

    public void addOrder(Order order) {
        myOrders.add(order);
    }

    public List<CompletableFuture<Void>> processAllMyOrdersInOwnThread(DeliveryService service) {
        List<CompletableFuture<Void>> futures = new LinkedList<>();
        for (Order order : myOrders) {
            myOrders.remove(order);
            futures.add(
                    CompletableFuture.runAsync(
                            () -> service.processOrder(order, myPromoCodes)
                    )
            );
        }
        return futures;
    }

    @Override
    public String toString() {
        return String.format("%s%n - has promos (%d): %s%n - has orders (%d): %s",
                name, myPromoCodes.size(), myPromoCodes, myOrders.size(), myOrders);
    }
}
