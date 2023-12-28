package Thread_1;

import java.util.ArrayList;

public class MailSender {
    public static void main(String[] args) {
        ArrayList<Thread> threads = new ArrayList<>();
        int threadCount = 5;
        int messageForOneThread = 200;
        for (int i = 0; i < threadCount; i++) {
            int finalI = i;
            threads.add(new Thread(() -> new SenderRunnable(finalI * messageForOneThread + 1, finalI * messageForOneThread + messageForOneThread).run()));
            threads.get(i).start();
        }

        for (int i = 0; i < threadCount; i++) {
            try {
                threads.get(i).join();
            } catch (InterruptedException e) {
                System.out.println(i + " thread has failed");
            }
        }

        System.out.println("All threads complete");
    }
}
