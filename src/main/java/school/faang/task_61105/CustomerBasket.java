package school.faang.task_61105;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static school.faang.task_61105.Main.CUSTOMERS_QUANTITY;
import static school.faang.task_61105.Main.GOODS_QUANTITY_PRECISION;
import static school.faang.task_61105.Main.MAX_QUANTITY_PER_CUSTOMER;
import static school.faang.task_61105.Main.PRICE_PRECISION;
import static school.faang.task_61105.RoundDouble.roundDouble;

@Slf4j
@Getter
@ToString
public class CustomerBasket {
    private static int nextId = 1;
    private final int id;
    private final Map<Good, Double> customerItems;

    public CustomerBasket() {
        this.id = nextId++;
        this.customerItems = new HashMap<>();
    }

    public void addItem(Good good, double quantity) {
        customerItems.put(good, customerItems.getOrDefault(good, 0.0)
                + roundDouble(quantity, GOODS_QUANTITY_PRECISION));
    }

    public double getTotalItemsQuantity() {
        return customerItems.values().stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    public double getTotalCost() {
        return customerItems.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getGoodPrice() * entry.getValue())
                .sum();
    }

    protected static List<CustomerBasket> getCustomerBaskets(Map<Good, Double> products) {
        Random random = new Random();

        List<CustomerBasket> customers = new ArrayList<>();
        for (int i = 0; i < CUSTOMERS_QUANTITY; i++) {
            CustomerBasket basket = new CustomerBasket();
            List<Good> productKeys = new ArrayList<>(products.keySet());
            int numItems = random.nextInt(1, MAX_QUANTITY_PER_CUSTOMER + 1);

            for (int j = 0; j < numItems; j++) {
                int randomIndex = random.nextInt(productKeys.size());
                Good randomGood = productKeys.get(randomIndex);
                double quantity = random.nextDouble(0, MAX_QUANTITY_PER_CUSTOMER);
                basket.addItem(randomGood, quantity);
            }
            customers.add(basket);
        }
        return customers;
    }

    public void printBasket() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer ID: ").append(id).append("\n");

        for (Map.Entry<Good, Double> entry : customerItems.entrySet()) {
            Good good = entry.getKey();
            double quantity = entry.getValue();
            double totalCost = good.getGoodPrice() * quantity;

            sb.append(String.format("Product: %-15s | Price: %-7.2f | Quantity: %-6.3f | Cost: %-8.2f%n",
                    good.getGoodName(),
                    good.getGoodPrice(),
                    RoundDouble.roundDouble(quantity, GOODS_QUANTITY_PRECISION),
                    RoundDouble.roundDouble(totalCost, PRICE_PRECISION)));
        }

        sb.append("------------------\n")
                .append(String.format("Total items: %-8.3f | Total cost: %-10.2f%n",
                        getTotalItemsQuantity(),
                        getTotalCost()))
                .append("==================\n");

        log.info("\n{}", sb);
    }
}


