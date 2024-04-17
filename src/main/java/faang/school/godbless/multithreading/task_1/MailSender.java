package faang.school.godbless.multithreading.task_1;

import faang.school.godbless.multithreading.task_1.sender.SenderRunnable;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final int NUMBERS_OF_SENDERS = 5;

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for(int i = 0; i < NUMBERS_OF_SENDERS; i++) {
            int startIndex = i * 100 + 1;
            int lastIndex = startIndex + 99;
            Thread thread = new Thread(new SenderRunnable(startIndex, lastIndex));
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(Thread.currentThread().getName() + " сообщает о том, что все письма отправлены");
    }
}