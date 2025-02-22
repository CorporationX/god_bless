package school.faang.bjs2_60564;

import java.util.Arrays;
import java.util.List;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {

        List<Thread> threads = Arrays.asList(
                new Thread(new SenderRunnable(1, 200)),
                new Thread(new SenderRunnable(201, 400)),
                new Thread(new SenderRunnable(401, 600)),
                new Thread(new SenderRunnable(601, 800)),
                new Thread(new SenderRunnable(801, 1000))
        );

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Все письма успешно обработаны!");
    }
}
