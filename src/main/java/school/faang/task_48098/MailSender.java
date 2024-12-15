package school.faang.task_48098;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static int countMessage = 1000;
    private static int countThread = 5;
    private static int countMassageInThread = countMessage / countThread;

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < countThread; i++) {
            int start = i * countMassageInThread;
            int end = (i + 1) * countMassageInThread;
            threads.add(new Thread(new SenderRunnable(start, end)));
            threads.get(i).start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Все письма успешно отправлены!");
    }
}
