package school.faang.walmart;

/**
 * @author Danil Pudovkin
 * @since 22.06.2025
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        CustomerItem[][] customers = {
                {
                        new CustomerItem("Item A1", 10.0),
                        new CustomerItem("Item A2", 20.5),
                        new CustomerItem("Item A3", 15.75)
                },
                {
                        new CustomerItem("Item B1", 8.0),
                        new CustomerItem("Item B2", 13.5),
                        new CustomerItem("Item B3", 17.2)
                },
                {
                        new CustomerItem("Item C1", 12.0),
                        new CustomerItem("Item C2", 21.5),
                        new CustomerItem("Item C3", 15.2)
                }
        };

        CashierThread[] cashiers = new CashierThread[customers.length];
        for (int i = 0; i < customers.length; i++) {
            cashiers[i] = new CashierThread("Cashier %s".formatted(i), customers[i]);
        }

        for (var cashier : cashiers) {
            cashier.start();
        }

        for (var cashier : cashiers) {
            cashier.join();
        }
    }
}
