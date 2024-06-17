package faang.school.godbless.YouWorkForMicrosoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static final int NUMBER_OF_MESSAGES = 1000;
    public static final int NUMBER_OF_THREADS = 5;

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        int tasksOnThread = NUMBER_OF_MESSAGES / NUMBER_OF_THREADS;

        System.out.println("Start sending messages");

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            int startIndex = tasksOnThread * i;
            int endIndex = tasksOnThread * (i + 1) - 1;

            SenderRunnable currentSendler = new SenderRunnable(startIndex, endIndex);
            Thread currentThread = new Thread(currentSendler);
            threads.add(currentThread);
            currentThread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Sending messages completed");
    }
}
