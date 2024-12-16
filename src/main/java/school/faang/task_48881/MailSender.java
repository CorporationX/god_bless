package school.faang.task_48881;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final int ONE_THREAD = 200;
    private static final int COUNT_THREAD = 5;

    public static void main(String[] args) throws InterruptedException {

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < COUNT_THREAD; i++) {
            int start = i * ONE_THREAD + 1;
            int end = (i + 1) * ONE_THREAD;
            Thread thread = null;
            try {
                thread = new Thread(new SenderRunnable(start, end));
            } catch (Exception e) {
                System.out.println("Ошибка в потоке: " + e.getMessage());
                e.printStackTrace();
            }
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Поток был прерван: " + thread.getName());
            }
        }
        System.out.println("Все письма успешно отправлены!");
    }
}
