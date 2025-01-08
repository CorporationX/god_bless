package derschrank.sprint04.task25.bjstwo_51104;

import derschrank.sprint04.task25.bjstwo_51104.units.Order;
import derschrank.sprint04.task25.bjstwo_51104.units.Product;
import derschrank.sprint04.task25.bjstwo_51104.units.PromoCode;
import derschrank.sprint04.task25.bjstwo_51104.units.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final String SPLITTER = "\n-------------------------------\n";
    private static final int COUNT_OF_USERS = 3;
    private static final int COUNT_OF_ORDERS_BY_USER = 10;
    private static DeliveryService service;
    private static Product[] products;
    private static String[] names;

    private static int countOfGenerationOfPromoCodes = 0;

    public static void main(String[] args) {
        service = new DeliveryService();
        products = getProducts();

        names = getNames();
        List<User> buyers = generateUsers(COUNT_OF_USERS);
        buyers.forEach(Main::generatePromoCodesAndImplementItForUser);
        buyers.forEach(Main::generateOrdersAndImplementItForUser);

        System.out.println(SPLITTER + "WE HAVE USERS WITH ORDERS AND PROMOS:" + SPLITTER);
        buyers.forEach(System.out::println);

        System.out.println(SPLITTER + "DELIVERY SERVICE HAS PROMOS:" + SPLITTER);
        System.out.println(service.getAllActivePromoCodes());

        System.out.println(SPLITTER + "PROCESSING ORDERS:" + SPLITTER);
        List<CompletableFuture<Void>> futures = new LinkedList<>();
        for (User user : buyers) {
            futures.addAll(user.processAllMyOrdersInOwnThread(service));
        }
        futures.forEach(CompletableFuture::join);

    }

    private static List<User> generateUsers(int count) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            users.add(new User(names[i % names.length]));
        }
        return users;
    }

    private static Product[] getProducts() {
        return new Product[]{
                new Product("Milk 1l", 100),
                new Product("Kefir 1l", 110),
                new Product("Bread 0.5kg", 50),
                new Product("Zuker 1kg", 70),
                new Product("Eggs 10st", 150),
                new Product("Cola 2l", 200),
        };
    }

    private static void generatePromoCodesAndImplementItForUser(User user) {
        PromoCode[] codes = generateActivePromoCodes();
        Arrays.stream(codes).map(PromoCode::getCode).forEach(user::addPromoCode);
    }

    private static PromoCode[] generateActivePromoCodes() {
        int i = ++countOfGenerationOfPromoCodes;
        PromoCode[] codes = new PromoCode[]{
                new PromoCode("Easy coupon #" + i + "-1"),
                new PromoCode("Easy coupon #" + i + "-2"),
                new PromoCode("NY coupon #" + i, 20, 100),
                new PromoCode("BlackFriday #" + i, 30, 500),
                new PromoCode("SuperTotal #" + i, 50, 1000)
        };
        Arrays.stream(codes).forEach(service::addPromoCode);
        return codes;
    }

    private static void generateOrdersAndImplementItForUser(User user) {
        for (int i = 1; i <= COUNT_OF_ORDERS_BY_USER; i++) {
            Order order = new Order("O-" + user.name() + "-" + i);
            user.addOrder(order);

            for (int p = 0; p <= i; p++) {
                order.addProduct(products[p % products.length]);
            }
        }
    }

    private static String[] getNames() {
        return new String[]{
                "Ivan", "Petr", "Sidr", "Fedor", "Slava", "Dima", "Misha", "Jula", "Ola", "Polina", "Ekaterina"
        };
    }

}
