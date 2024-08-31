package ru.kraiush.threads.BJS2_24117;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class AppCashierCustomer {

    public static void main(String[] args) throws InterruptedException {

        String[] customers = {"Paul", "Sharon", "Maggie", "Lewis"};

        Map<String, List<Goods>> customerBasket = new HashMap<>();

        for (int i = 0; i < customers.length; i++) {
            customerBasket.put(customers[i], null);
            int typeGoods = ThreadLocalRandom.current().nextInt(1, 5);
            List<Goods> listGoods = new ArrayList<>();
            for (int j = 1; j <= typeGoods; j++) {
                int good = ThreadLocalRandom.current().nextInt(1, 10);
                ;
                listGoods.add(new Goods(getGoodsType(good), ThreadLocalRandom.current().nextInt(1, 5)));
                customerBasket.put(customers[i], listGoods);
            }
            Thread thread = new CashierThread(i, listGoods);
            System.out.println("Customer <" + customers[i] + "> is going  to cashier");
            Thread.sleep(2000);
            thread.start();
        }
        System.out.println();
        customerBasket.forEach((K, V) -> System.out.println("customer's baskets - key: " + K + " value: " + V));
    }

    public static String getGoodsType(int type) {
        String[] goodsNames = {"shovel", "hammer", "rake", "pliers", "scissors", "glue", "saw", "file", "hacksaw", "sickle"};
        return goodsNames[type];
    }
}
