package school.faang;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    private static final int NUMS_OF_CASHIERS = 7;
    private static final Random RANDOM = new Random();

    public static void main(String[] args) throws InterruptedException {
        List<List<String>> customers = Arrays.asList(
                Arrays.asList("Колбаса", "Мороженое"),
                Arrays.asList("Раки", "Пиво", "Кальмар"),
                Arrays.asList("Йогурт", "Гранола", "Протеиновый батончик", "Курица")
        );

        CashierThread[] cashiers = new CashierThread[customers.size()];

        int i = 0;
        for (List<String> customer : customers) {
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
