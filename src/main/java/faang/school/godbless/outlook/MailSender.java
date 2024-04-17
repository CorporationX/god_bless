package faang.school.godbless.outlook;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        int i = 1;
        List<Thread> threads = new ArrayList<>();
        while (i < 1000) {
            Thread thread = new Thread(new SenderRunnable(i, i + 199));
            threads.add(thread);
            i += 200;
            thread.start();
        }
        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println("All email sends");
    }
}
