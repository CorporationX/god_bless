package faang.school.godbless.YouWorkForMicrosoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final List<Integer> Batch = new ArrayList<>(200);
    private static final int SIZE_BATCH = 200;
    private static final List<Thread> THREADS = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            if (Batch.size() == 200) {
                Thread thread = new Thread(new SenderRunnable(Batch.get(0), Batch.get(SIZE_BATCH - 1)));
                thread.start();
                Batch.clear();
                THREADS.add(thread);
            } else {
                Batch.add(i);
            }
        }

        for (Thread thread : THREADS) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("all messages sent");
    }
}
