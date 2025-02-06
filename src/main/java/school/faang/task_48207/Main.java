package school.faang.task_48207;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static school.faang.task_48207.CustomerBasket.getCustomerBaskets;

@Slf4j
public class Main {
    public static final int MAX_QUANTITY_PER_CUSTOMER = 5;
    public static final int CUSTOMERS_QUANTITY = 5550;
    public static final int NUM_CASHIERS = 12;
    public static final int GOODS_QUANTITY_PRECISION = 3;
    public static final int PRICE_PRECISION = 2;


    public static void main(String[] args) {

        Map<Good, Double> products = new HashMap<>();
        products.put(new Good("Apple Moldova", 89.90), 45.57);
        products.put(new Good("Apple Gala", 129.90), 12.34);
        products.put(new Good("Banana", 149.90), 67.89);
        products.put(new Good("Orange", 109.90), 23.45);
        products.put(new Good("Grapes", 189.50), 90.12);
        products.put(new Good("Mango", 250.00), 56.78);
        products.put(new Good("Pineapple", 320.75), 34.56);
        products.put(new Good("Kiwi", 170.20), 78.90);
        products.put(new Good("Strawberry", 220.90), 12.34);
        products.put(new Good("Avocado", 280.10), 87.65);
        products.put(new Good("Lemon", 75.50), 43.21);
        products.put(new Good("Lime", 65.80), 65.43);

        List<CustomerBasket> customers = getCustomerBaskets(products);

        List<CashierThread> cashiers = new ArrayList<>();

        for (int i = 1; i <= NUM_CASHIERS; i++) {
            int from = (i - 1) * (customers.size() / NUM_CASHIERS);
            int to = i * (customers.size() / NUM_CASHIERS);

            if (i == NUM_CASHIERS) {
                to = customers.size();
            }
            List<CustomerBasket> basketsToPass = customers.subList(from, to);
            cashiers.add(new CashierThread(i, basketsToPass));
        }

        for (CashierThread cashier : cashiers) {
            cashier.start();
        }

        try {
            for (CashierThread cashier : cashiers) {
                cashier.join();
            }
        } catch (InterruptedException e) {
            log.info("Cashiers work was interrupted: {}", e.getMessage());
        }
    }


}