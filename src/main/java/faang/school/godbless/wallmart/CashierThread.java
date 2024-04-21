package faang.school.godbless.wallmart;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.ThreadLocalRandom;

@Getter
@AllArgsConstructor
public class CashierThread extends Thread{
    private int cashierId;
    private String[] customerItems;

    @Override
    public void run() {
        int totalItems = customerItems.length;
        double totalCost = 0;
        for (String item : customerItems) {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            totalCost += Math.random() * 100;
        }
        System.out.println("Кассир " + cashierId + " обработал "
                + totalItems + " товар(ов) на общую сумму $" + String.format("%.2f", totalCost));
    }

    public static void main(String[] args) {
        String[][] customers = {
                {"Молоко", "Яйца"},
                {"Сок", "Чипсы", "Мороженое"},
                {"Мясо"}};
        CashierThread[] cashiers = new CashierThread[customers.length];
        for (int i = 0; i < customers.length; i++) {
            cashiers[i] = new CashierThread(i+1, customers[i]);
        }
        for (CashierThread cashier : cashiers) {
            cashier.start();
        }
    }
}
