package microsoft_993;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static int countThreads = 5;
    public static int countMessage = 1000;
    public static int countMessageOfThread = countMessage / countThreads;

    public static void main(String[] args) throws InterruptedException {

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int start = i * countMessageOfThread;
            int end = start + countMessageOfThread;
            Thread thread = new Thread(() -> new SenderRunnable(start, end).run());
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Все сообщения отправлены");
    }
}