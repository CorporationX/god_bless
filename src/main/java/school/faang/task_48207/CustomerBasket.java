package school.faang.task_48207;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static school.faang.task_48207.Main.CUSTOMERS_QUANTITY;
import static school.faang.task_48207.Main.GOODS_QUANTITY_PRECISION;
import static school.faang.task_48207.Main.MAX_QUANTITY_PER_CUSTOMER;
import static school.faang.task_48207.Main.PRICE_PRECISION;
import static school.faang.task_48207.RoundDouble.roundDouble;

@Getter
@ToString
public class CustomerBasket {
    private final Map<Good, Double> customerItems;

    public CustomerBasket() {
        this.customerItems = new HashMap<>();
    }

    public void addItem(Good good, double quantity) {
        customerItems.put(good, customerItems.getOrDefault(good, 0.0)
                + roundDouble(quantity, GOODS_QUANTITY_PRECISION));
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
        System.out.println("Customer Basket:");
        for (Map.Entry<Good, Double> entry : customerItems.entrySet()) {
            Good good = entry.getKey();
            double quantity = roundDouble(entry.getValue(), GOODS_QUANTITY_PRECISION);
            double price = good.getGoodPrice();
            double totalCost = roundDouble(price * quantity, PRICE_PRECISION);
            System.out.println("Product: " + good.getGoodName() + ", Price: " + good.getGoodPrice()
                    + ", Quantity: " + quantity + ", Total Cost: " + totalCost);
        }
        System.out.println("------------------");
    }
}


