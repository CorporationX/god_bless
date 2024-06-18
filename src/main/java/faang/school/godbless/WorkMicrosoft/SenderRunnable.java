package faang.school.godbless.WorkMicrosoft;

import java.util.ArrayList;
import java.util.List;

public class SenderRunnable {
    private static final int COUNT_LETTERS_IN_ONE_THREAD = 200;
    private static final int COUNT_THREAD = 5;

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < COUNT_THREAD; i++) {
            int start = i * COUNT_LETTERS_IN_ONE_THREAD;
            Thread thread = new Thread(new MailSender(start, start + COUNT_LETTERS_IN_ONE_THREAD));
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("End!");
    }

}
