package faang.school.godbless.thirdSprint.QueueAtWalmart;

public class Main {
    public static void main(String[] args) {
        int[][] customers = {{5, 9, 6}, {2, 5, 7}};
        CashierThread[] cashiers = new CashierThread[customers.length];

        for (int i = 0; i < customers.length; i++) {
            cashiers[i] = new CashierThread(i + 1, customers[i]);
            cashiers[i].start();
        }

        for (CashierThread cashier : cashiers) {
            try {
                cashier.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        for (CashierThread cashier : cashiers) {
            System.out.println("Касса " + cashier.getCashierId() + " обработала " + cashier.getItemsCount()
                    + " товаров на общую сумму " + cashier.getTotalCost());
        }
    }
}
