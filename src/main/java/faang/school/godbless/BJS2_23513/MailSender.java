package faang.school.godbless.BJS2_23513;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    static List<Thread> threads = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0, startIndex = 0, endIndex = 200; i < 5; i++, startIndex += 200, endIndex += 200) {
            threads.add(new Thread(new SenderRunnable(startIndex, endIndex)));
        }
        threads.forEach(Thread::start);
        for (Thread thread : threads) {
            try {
                thread.join();
                System.out.println(thread.getName() + ": Done");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("All threads done");
    }
}
