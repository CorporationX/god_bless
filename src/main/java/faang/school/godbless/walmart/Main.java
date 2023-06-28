package faang.school.godbless.walmart;

public class Main {
    public static void main(String[] args) {
        String[][] customers = new String[][]{
                {"bread", "milk", "cheese"},
                {"beer", "crackers"},
                {"soap", "rope", "chair"}
        };
        CashierThread[] cashier = new CashierThread[customers.length];

        for (int i = 0; i < cashier.length; i++) {
            cashier[i] = new CashierThread("wal" + "'" + i + "'", customers[i]);
            cashier[i].start();
        }
    }
}
