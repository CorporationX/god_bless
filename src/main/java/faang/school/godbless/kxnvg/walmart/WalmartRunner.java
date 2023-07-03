package faang.school.godbless.kxnvg.walmart;

import lombok.SneakyThrows;

public class WalmartRunner {

    @SneakyThrows
    public static void main(String[] args) {
        int[][] customers = {{5, 7, 3, 2, 5}, {1, 2, 3}, {6, 5, 2}, {10, 2, 1, 3, 5}, {1, 1, 1}};
        CashierThread[] cashiers = new CashierThread[customers.length];

        for (int i = 0; i < cashiers.length; i++) {
            cashiers[i] = new CashierThread(i + 1, customers[i]);
            cashiers[i].start();
        }

        for (CashierThread cashier : cashiers) {
            System.out.println("Касса №" + cashier.getCashierId() + " обработала " + cashier.getItemsNumber() +
                    " товаров на общую сумму " + cashier.getTotalCost() + "$");
        }
    }
}
