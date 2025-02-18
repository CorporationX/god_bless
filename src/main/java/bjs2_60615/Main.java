package bjs2_60615;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Main {
    private static final int NUM_OF_CASHIERS = 3; // Количество кассиров

    public static void main(String[] args) throws InterruptedException {
        int[][] customers = {
                {5, 8, 1, 3},
                {44, 8, 7},
                {1},
                {13, 5, 9, 10, 15}
        };

        Random rnd = new Random();
        Queue<CashierThread>[] cashiers = new LinkedList[NUM_OF_CASHIERS];
        for (int i = 0; i < customers.length; i++) {
            int cashierId = rnd.nextInt(NUM_OF_CASHIERS); // Случайная касса от 1 до NUM_OF_CASHIERS
            if (cashiers[cashierId] == null) {
                cashiers[cashierId] = new LinkedList<>();
            }
            cashiers[cashierId].add(new CashierThread(cashierId + 1, customers[i]));
        }

        List<Thread> cashierProcessThreads = new ArrayList<>();
        for (Queue<CashierThread> cashierQueue : cashiers) {
            if (cashierQueue != null) {
                Thread cashierProcessThread = new Thread(() -> processCashier(cashierQueue));
                cashierProcessThreads.add(cashierProcessThread);
                cashierProcessThread.start();
            }
        }

        for (Thread cashierProcessThread : cashierProcessThreads) {
            cashierProcessThread.join();
        }
    }

    private static void processCashier(Queue<CashierThread> cashierQueue) {
        while (!cashierQueue.isEmpty()) {
            CashierThread cashierThread = cashierQueue.poll();

            cashierThread.start();
            try {
                cashierThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
