package BJS2_5622;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = startIndex + 199;
            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            thread.start();
            threads.add(thread);
        }

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException ex) {
                throw new RuntimeException();
            }
        });
        System.out.println("Письма успешно отправлены");
    }
}
