package faang.school.godbless.concurrency.coupons;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;


@Slf4j
public class Main {
    private static List<Promocode> promocodeList = new ArrayList<>();
    private static List<Product> productList = new ArrayList<>();

    static {
        promocodeList.add(new Promocode("fg4dg4", 20, LocalDate.of(2024, 8, 27), 600));
        promocodeList.add(new Promocode("dfgdf", 10, LocalDate.of(2024, 8, 27), 400));
        promocodeList.add(new Promocode("43re53", 15, LocalDate.of(2024, 8, 27), 500));
        promocodeList.add(new Promocode("ert435", 30, LocalDate.of(2024, 8, 27), 1500));
        promocodeList.add(new Promocode("f89dg7", 5, LocalDate.of(2024, 8, 27), 200));

        productList.add(new Product("Pizza", 500));
        productList.add(new Product("Burger", 300));
        productList.add(new Product("Shaverma", 250));
        productList.add(new Product("Soda", 100));
        productList.add(new Product("Beer", 150));
    }

    public static void main(String[] args) {
        DeliveryService deliveryService = new DeliveryService();

        deliveryService.addPromocode(promocodeList.get(0));
        deliveryService.addPromocode(promocodeList.get(1));
        deliveryService.addPromocode(promocodeList.get(2));
        deliveryService.addPromocode(promocodeList.get(3));
        deliveryService.addPromocode(promocodeList.get(4));


        log.info("Delivery service work starts.");

        deliveryService.printOrdersList();
        deliveryService.printActivePromocodes();


        List<CompletableFuture<Void>> orderTasks = new ArrayList<>();

        orderTasks.add(CompletableFuture.runAsync(() -> {
            Order newOrder = new Order(1);
            newOrder.addProductToBasket(productList.get(0));
            newOrder.addProductToBasket(productList.get(4));
            newOrder.addProductToBasket(productList.get(4));

            deliveryService.processOrder(newOrder, List.of(promocodeList.get(1), promocodeList.get(0), promocodeList.get(4)));
        }));

        orderTasks.add(CompletableFuture.runAsync(() -> {
            Order newOrder = new Order(2);
            newOrder.addProductToBasket(productList.get(1));
            newOrder.addProductToBasket(productList.get(3));
            newOrder.addProductToBasket(productList.get(3));

            deliveryService.processOrder(newOrder, List.of(promocodeList.get(1), promocodeList.get(0), promocodeList.get(2)));
        }));

        orderTasks.add(CompletableFuture.runAsync(() -> {
            Order newOrder = new Order(3);
            newOrder.addProductToBasket(productList.get(1));
            newOrder.addProductToBasket(productList.get(2));
            newOrder.addProductToBasket(productList.get(4));
            newOrder.addProductToBasket(productList.get(3));

            deliveryService.processOrder(newOrder, List.of(promocodeList.get(3), promocodeList.get(0), promocodeList.get(4)));
        }));


        orderTasks.add(CompletableFuture.runAsync(() -> {
            Order newOrder = new Order(4);
            newOrder.addProductToBasket(productList.get(1));
            newOrder.addProductToBasket(productList.get(0));
            newOrder.addProductToBasket(productList.get(2));
            newOrder.addProductToBasket(productList.get(4));
            newOrder.addProductToBasket(productList.get(3));

            deliveryService.processOrder(newOrder, List.of(promocodeList.get(1), promocodeList.get(2), promocodeList.get(3)));
        }));


        CompletableFuture.allOf(orderTasks.toArray(new CompletableFuture[0])).join();

        log.info("Delivery service work stops.");

        deliveryService.printOrdersList();
        deliveryService.printActivePromocodes();
    }
}
