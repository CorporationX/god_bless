package school.faang.task_52223;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DeliveryService deliveryService = initialization();

    }

    public static DeliveryService initialization() {

        List<Product> productsOne = List.of(
                new Product("Product 1", 600),
                new Product("Product 2", 500),
                new Product("Product 3", 300));

        List<Product> productsTwo = List.of(
                new Product("Product 4", 200),
                new Product("Product 5", 400),
                new Product("Product 6", 100));
        List<Product> productsThree = List.of(
                new Product("Product 7", 50),
                new Product("Product 8", 20),
                new Product("Product 9", 10));

        Order orderOne = new Order();
        orderOne.getProducts().addAll(productsOne);
        Order orderTwo = new Order();
        orderTwo.getProducts().addAll(productsTwo);
        Order orderThree = new Order();
        orderThree.getProducts().addAll(productsThree);

        List<Order> orders = List.of(orderOne, orderTwo, orderThree);

        DeliveryService deliveryService = new DeliveryService();

        deliveryService.getProcessedOrders().addAll(orders);

        deliveryService.addPromoCode(new PromoCode("PROMO10", 10, LocalDate.of(2023, 12, 31), PromoCodeStatus.ACTIVE));
        deliveryService.addPromoCode(new PromoCode("PROMO20", 20, LocalDate.of(2023, 11, 30), PromoCodeStatus.ACTIVE));
        deliveryService.addPromoCode(new PromoCode("PROMO30", 30, LocalDate.of(2023, 12, 31), PromoCodeStatus.INVALID));

        return deliveryService;
    }

}
