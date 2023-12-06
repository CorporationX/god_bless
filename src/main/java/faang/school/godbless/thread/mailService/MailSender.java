package faang.school.godbless.thread.mailService;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            SenderRunnable senderRunnable = new SenderRunnable(startIndex, startIndex + 200);
            Thread thread = new Thread(senderRunnable);
            threads.add(thread);
            thread.start();
        }

        int counter = 0;
        for (Thread thread : threads) {
            thread.join();
            if (!thread.isAlive()) {
                counter++;
            }
        }

        if (counter == threads.size()) {
            System.out.println("Все потоки закончили работу");
        }
    }
}
