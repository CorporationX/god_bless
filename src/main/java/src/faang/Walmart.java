package src.faang;

import src.faang.model.CashierThread;
import src.faang.model.Customer;
import src.faang.model.CustomerProduct;

import java.util.Random;

public class Walmart {

    private static final Customer FIRST_CUSTOMER = new Customer(
            new CustomerProduct[]{
                    new CustomerProduct("Булка с маком", 50),
                    new CustomerProduct("Хлеб", 30),
                    new CustomerProduct("Молоко", 100)
            }
    );

    private static final Customer SECOND_CUSTOMER = new Customer(
            new CustomerProduct[]{
                    new CustomerProduct("Ложка", 30),
                    new CustomerProduct("Вилка", 20),
                    new CustomerProduct("Кошка", 150)
            }
    );

    private static final Random RANDOM = new Random();

    public static void main(String[] args) throws InterruptedException {
        final Customer[] customers = {
                FIRST_CUSTOMER,
                SECOND_CUSTOMER
        };

        final CashierThread[] cashiers = new CashierThread[customers.length];
        setupCashiersForEveryCustomer(customers, cashiers);

        for (CashierThread thread : cashiers) {
            thread.start();
            thread.join();
        }
    }

    private static void setupCashiersForEveryCustomer(Customer[] customers, CashierThread[] cashiers) {
        int customersCount = customers.length;
        for (int i = 0; i < customersCount; i++) {
            Customer randomCustomer = customers[RANDOM.nextInt(customersCount)];
            cashiers[i] = new CashierThread(i, randomCustomer.getCustomerProducts());
        }
    }
}

