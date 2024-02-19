package faang.school.godbless.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String... args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            Thread thread = new Thread(new SenderRunnable(i, (i + 1) * 200));
            threads.add(thread);
            thread.start();
        }
        for (var thread : threads) {
            thread.join();
        }
    }
}
