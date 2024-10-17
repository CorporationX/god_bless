package org.example.model.microsoft;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = this.startIndex; i < endIndex; i++) {
            System.out.println(String.format("success sent %d!", i + 1));
        }
    }

    public static List<Thread> optimizeSendingNotifications(int notificationNumber, int threadsNumber) {
        int numberOfMessageForOneThread = notificationNumber / threadsNumber;
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < threadsNumber; i++) {
            threads.add(new Thread(new SenderRunnable(numberOfMessageForOneThread * i, (i + 1) * numberOfMessageForOneThread)));
        }

        return threads;
    }

    public static void startThreadList(List<Thread> threads) {
        threads.forEach(thread -> {
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("Success sent all mail notifications!");
    }
}
