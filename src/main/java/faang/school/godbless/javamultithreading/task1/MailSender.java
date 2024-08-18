package faang.school.godbless.javamultithreading.task1;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            Thread thread = new Thread(new SenderRunnable(startIndex, startIndex + 200));
            threads.add(thread);
            thread.start();
        }
        threads.forEach(thread -> {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
        System.out.println("Завершение всех потоков");
    }
}
