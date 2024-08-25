package work_in_microsoft;

import java.util.Arrays;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int threadCount = 5;
        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; ++i) {
            int startIndex = i * 200;
            int endIndex = startIndex + 200;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Все сообщения отправлены");
    }
}
