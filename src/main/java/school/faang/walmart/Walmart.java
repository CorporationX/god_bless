package school.faang.walmart;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class Walmart {
    private static final int CASHIERS_COUNT = 2;

    public static void main(String[] args) throws InterruptedException {
        Item[][] customers = createCustomerItems();
        CashierThread[] cashiers = createCashiers(customers);

        for (CashierThread cashier : cashiers) {
            cashier.start();
        }
        for (CashierThread cashier : cashiers) {
            cashier.join();
        }

        printStatistics(cashiers);
    }

    private static Item[][] createCustomerItems() {
        return new Item[][]{
                {
                        new Item("A", 85.5),
                        new Item("B", 45.22),
                        new Item("C", 120)
                },
                {
                        new Item("Z", 350.75),
                        new Item("X", 280.4)
                },
                {
                        new Item("A", 60),
                        new Item("D", 95.3),
                        new Item("F", 210.58),
                        new Item("R", 145)
                },
                {
                        new Item("S", 175.25),
                        new Item("D", 420.6)
                },
                {
                        new Item("E", 310),
                        new Item("T", 135)
                }
        };
    }

    private static CashierThread[] createCashiers(Item[][] customers) {
        Random random = new Random();
        CashierThread[] cashiers = new CashierThread[customers.length];
        for (int i = 0; i < customers.length; i++) {
            int cashierId = random.nextInt(CASHIERS_COUNT) + 1;
            cashiers[i] = new CashierThread(cashierId, customers[i]);
        }
        return cashiers;
    }

    private static void printStatistics(CashierThread[] cashiers) {
        int totalItems = 0;
        double totalPrice = 0;

        for (int i = 0; i < cashiers.length; i++) {
            log.info("Покупатель {}: Кассир {}, Товаров: {}, Сумма: {}",
                    i + 1,
                    cashiers[i].getCashierId(),
                    cashiers[i].getCustomerItems().length,
                    cashiers[i].getTotalCost());

            totalItems += cashiers[i].getCustomerItems().length;
            totalPrice += cashiers[i].getTotalCost();
        }

        log.info("Всего обработано товаров: {}", totalItems);
        log.info("Общая стоимость товаров: {}", totalPrice);
    }
}
