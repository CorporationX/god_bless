package faang.school.godbless.multithreading.walmart;

public class Main {
    public static void main(String[] args) {
        Item[][] customers = initCustomers();
        CashierThread[] cashiers = new CashierThread[4];

        for (int i = 0; i < 4; i++) {
            cashiers[i] = new CashierThread(i + 1, customers[i]);
            cashiers[i].start();
        }

        for (CashierThread cashier : cashiers) {
            try {
                cashier.join();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }

    }

    private static Item[][] initCustomers() {
        return new Item[][] {
            new Item[] {
                    new Item("Item 1", 10),
                    new Item("Item 2", 20),
                    new Item("Item 3", 30)
            },
            new Item[] {
                    new Item("Item 1", 40),
                    new Item("Item 2", 50),
            },
            new Item[] {
                    new Item("Item 1", 10),
                    new Item("Item 2", 30),
            },
            new Item[] {
                    new Item("Item 1", 20),
                    new Item("Item 2", 40),
                    new Item("Item 3", 50),
            }
        };
    }
}
