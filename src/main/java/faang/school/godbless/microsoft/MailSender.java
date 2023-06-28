package faang.school.godbless.microsoft;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailSender {
    public static void main(String... args) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = startIndex + 200;
            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            thread.start();
            thread.join();

        }
        System.out.println("Все сообщения отправлены");

    }
}
