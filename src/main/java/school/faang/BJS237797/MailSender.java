package school.faang.BJS237797;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 5; i ++) {
            int startIndex = i * 200;
            int endIndex = (i + 1) * 200;
            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            threads.add(thread);
        }
        threads.forEach(Thread::start);
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("Все сообщения отправлены");
    }
}
