package school.faang.bjs2_37834;

import java.util.Arrays;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        List<Thread> list = Arrays.asList(
                new Thread(new SenderRunnable(1, 200)),
                new Thread(new SenderRunnable(201, 400)),
                new Thread(new SenderRunnable(401, 600)),
                new Thread(new SenderRunnable(601, 800)),
                new Thread(new SenderRunnable(801, 1000))
        );
        list.forEach(Thread::start);
        list.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("successful completion");
    }
}
