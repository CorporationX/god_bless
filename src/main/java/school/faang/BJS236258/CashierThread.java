package school.faang.BJS236258;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class CashierThread extends Thread {
    private int cashierId;
    private int[] customerItems;

    @Override
    public void run() {
        processCustomer(customerItems);
    }

    public void processCustomer(int[] customerItems) {
        System.out.println("Кассир " + cashierId + " начал обслуживание");
        int totalItems = 0;
        double totalCost = 0.0;

        for (int item : customerItems) {
            totalItems += item;
            double price = getPrice(item);
            totalCost += price;
            System.out.println("Товар: " + item + " шт., цена: " + price);
        }

        System.out.println("Кассир " + cashierId + " обработал " + totalItems + " товаров. Общая стоимость: " + totalCost);
    }

    private double getPrice(int item) {
        return item * 5.0;
    }

    public static void main(String[] args) {
        int[][] customers = {
                {3, 2, 5},
                {1, 4},
                {7, 1, 3},
                {6, 2},
                {4, 2, 1}
        };


        int numberOfCashiers = 3;
        CashierThread[] cashiers = new CashierThread[customers.length];
        Random random = new Random();


        for (int i = 0; i < customers.length; i++) {
            int cashierId = random.nextInt(numberOfCashiers);
            cashiers[i] = new CashierThread(cashierId, customers[i]);
        }


        for (CashierThread cashierThread : cashiers) {
            cashierThread.start();
        }


        for (CashierThread cashierThread : cashiers) {
            try {
                cashierThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Все покупатели обслужены.");
    }
}
