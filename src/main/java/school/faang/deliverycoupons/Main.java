package school.faang.deliverycoupons;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DeliveryService deliveryService = new DeliveryService();

        deliveryService.addPromoCode(new PromoCode("SAVE10", 10.0, LocalDateTime.now().plusDays(1), 20.0, false));
        deliveryService.addPromoCode(new PromoCode("SUPER20", 20.0, LocalDateTime.now().plusDays(1), 50.0, false));

        Order order = new Order(Arrays.asList(
                new Product("Pizza", 25.0),
                new Product("Burger", 15.0)
        ));

        List<String> promoCodes = Arrays.asList("SAVE10", "SUPER20");

        deliveryService.processOrder(order, promoCodes);
    }
}
