package faang.school.godbless.walmart;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String[][] customers = new String[][] {
                {"Milk", "Bread", "Apples"},
                {"Sandwich", "Cheese", "Bread"},
                {"Apples", "Oranges"},
                {"Bread", "Potatoes", "Cheese", "Milk"},
                {"Apples", "Potatoes", "Oranges"}};

        CashierThread[] cashiers = new CashierThread[customers.length];

        for (int i = 0; i < cashiers.length; i++) {
            cashiers[i] = new CashierThread(i, customers[i]);
            cashiers[i].start();
        }

        for (CashierThread cashier : cashiers) {
            cashier.join();
        }

        System.out.println("All customers have been processed.");
    }
}
