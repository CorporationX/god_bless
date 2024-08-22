package faang.school.godbless.BJS2_23683;

import java.util.ArrayList;
import java.util.List;

public class MailSender {

    public static final int RANGE_SIZE_MINUS_ONE = 199;

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>(5);

        for(int i = 0; i < 1000; i += 200) {
            threads.add(new Thread(new SenderRunnable(i, i + RANGE_SIZE_MINUS_ONE)));
        }

        for(var thread : threads) {
            thread.start();
        }

        for(var thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.err.println("interrupted: " + thread.getName());
            }
        }

        System.out.println("All messages were sent");
    }
}
