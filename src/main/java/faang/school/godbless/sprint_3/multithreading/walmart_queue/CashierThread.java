package faang.school.godbless.sprint_3.multithreading.walmart_queue;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor
@Getter
public class CashierThread extends Thread {
    private int cashierId;
    private String[] customerItems;

    public static void main(String[] args) {
        String[][] customers = new String[][]{{"Egg", "Milk", "Bread", "Water"},
                {"Milk", "Bottle of water", "Can of coke"},
                {"Bread", "Eggs", "Meat", "Chocolate", "Beer"}};

        CashierThread[] cashiers = new CashierThread[customers.length];

        for (int i = 0; i < customers.length; i++) {
            cashiers[i] = new CashierThread(i + 1, customers[i]);
        }
        for (CashierThread thread : cashiers) {
            thread.start();
            int quantity = thread.getCustomerItems().length;
            int cost = new Random().nextInt(700) + 800;
            System.out.printf("Кассир: %s -> Вы купили %d наименований и с Вас %d RUB %n", thread.cashierId, quantity, cost);
        }
        for (CashierThread thread : cashiers) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void run() {
        for (String stroke : customerItems) {
            System.out.printf("Кассир: %d взял в руки %s и пробил этот товар.%n", cashierId, stroke);
        }
    }
}
