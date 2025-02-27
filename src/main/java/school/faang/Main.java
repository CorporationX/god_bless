package school.faang;

import java.util.Random;

public class Main {
    private static final int NUMS_OF_CASHIERS = 7;
    private static final Random RANDOM = new Random();

    public static void main(String[] args) throws InterruptedException {
        String[][] customers = {
                {"Колбаса", "Мороженое"},
                {"Раки", "Пиво", "Кальмар"},
                {"Йогурт", "Гранола", "Протеиновый батончик", "Курица"}
        };

        CashierThread[] cashiers = new CashierThread[customers.length];

        int i = 0;
        for (String[] customer : customers) {
            int cashierId = RANDOM.nextInt(NUMS_OF_CASHIERS) + 1;
            cashiers[i++] = new CashierThread(cashierId, customer);
        }

        for (CashierThread cashier : cashiers) {
            cashier.start();
        }

        for (CashierThread cashier : cashiers) {
            cashier.join();
        }

        System.out.println("Все кассиры завершили работу!");
    }
}
