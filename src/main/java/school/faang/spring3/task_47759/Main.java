package school.faang.spring3.task_47759;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Product[][] customers = {
                {new Product("Apple", 1.0), new Product("Banana", 0.5),
                        new Product("Milk", 2.0)},
                {new Product("Bread", 1.5), new Product("Butter", 3.0)},
                {new Product("Eggs", 2.5), new Product("Cheese", 4.0),
                        new Product("Yogurt", 1.2)},
                {new Product("Chicken", 7.0), new Product("Rice", 3.5)},
                {new Product("Juice", 3.0), new Product("Cereal", 4.5),
                        new Product("Sugar", 2.0)}
        };
        int numberOfCashiers = 3;
        Random random = new Random();
        List<CashierThread> cashiers = new ArrayList<>();
        ExecutorService cashierPool = Executors.newFixedThreadPool(numberOfCashiers);

        for (int i = 1; i <= numberOfCashiers; i++) {
            CashierThread cashier = new CashierThread(i);
            cashiers.add(cashier);
            cashierPool.execute(cashier);
        }

        for (Product[] customerItems : customers) {
            int cashierIndex = random.nextInt(numberOfCashiers);
            cashiers.get(cashierIndex).addCustomer(customerItems);
        }

        cashierPool.shutdown();
        cashierPool.awaitTermination(20, TimeUnit.SECONDS);
        System.out.println("All customers have been served.");
    }
}
