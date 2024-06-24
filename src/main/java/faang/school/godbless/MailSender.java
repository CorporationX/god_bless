package faang.school.godbless;

import java.util.Arrays;

public class MailSender {
    private static final int BATCH = 200;
    public static void main(String[] args) {
        Thread [] thread = new Thread[5];
        for (int i = 0; i < 5; i++) {
            int startIndex = i * BATCH + 1;
            int endIndex = (i + 1) * BATCH;
            SenderRunnable sender = new SenderRunnable(startIndex, endIndex);
            thread[i] = new Thread(sender);
            thread[i].start();
        }
        try {
            for (int i = 0; i < 5; i++) {
                thread[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Все потоки закончили работу, программа завершена");
    }
}
