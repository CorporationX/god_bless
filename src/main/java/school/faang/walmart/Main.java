package school.faang.walmart;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Item[][] customers = initialCustomers();
        List<Integer> processedIndx = IntStream.range(0, customers.length)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        CashierThread[] cashiers = new CashierThread[customers.length];

        for (int i = 0; i < cashiers.length; i++) {
            Random random = new Random();
            int randomIndex = random.nextInt(processedIndx.size());
            int currCustomerIndx = processedIndx.get(randomIndex);
            cashiers[i] = new CashierThread(i, customers[currCustomerIndx]);
            processedIndx.remove(randomIndex);
            cashiers[i].start();
        }

        try {
            for (CashierThread cashier : cashiers) {
                cashier.join();
            }
            System.out.println("Все покупатели были обслужены");
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }

    private static Item[][] initialCustomers() {
        return new Item[][]{
                {
                        new Item("Apple", 10),
                        new Item("Banana", 15),
                        new Item("Orange", 20)
                },
                {
                        new Item("Milk", 50),
                        new Item("Bread", 30),
                        new Item("Butter", 40),
                        new Item("Cheese", 70)
                },
                {
                        new Item("Shampoo", 120),
                        new Item("Soap", 30),
                        new Item("Toothpaste", 25),
                        new Item("Towel", 200)
                },
                {
                        new Item("Phone", 5000),
                        new Item("Charger", 500),
                        new Item("Headphones", 1000)
                },
                {
                        new Item("Book", 150),
                        new Item("Pen", 10),
                        new Item("Notebook", 50),
                        new Item("Backpack", 600),
                        new Item("Pencil", 5)
                }
        };
    }
}
