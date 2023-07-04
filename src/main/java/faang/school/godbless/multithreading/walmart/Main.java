package faang.school.godbless.multithreading.walmart;

public class Main {
    public static void main(String[] args) {
        Item[][] customers = initCustomers();
        CashierThread[] cashiers = new CashierThread[customers.length];

        for (int i = 0; i < cashiers.length; i++) {
            cashiers[i] = new CashierThread(i + 1, customers[i]);
            cashiers[i].start();
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
