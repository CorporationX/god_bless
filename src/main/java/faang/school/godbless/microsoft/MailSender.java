package faang.school.godbless.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        List<String> messages = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            messages.add("message" + i);
        }
        for (int i = 0; i < 5; i++) {
            threads.add(new Thread(new SenderRunnable(i * 200, i * 200 + 199, i, messages)));
        }
        for (var thread : threads) {
            thread.start();
        }
        for (var thread : threads) {
            thread.join();
        }
        System.out.println("all messages processed");
    }
}
