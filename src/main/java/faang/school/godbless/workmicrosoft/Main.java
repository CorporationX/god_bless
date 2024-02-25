package faang.school.godbless.workmicrosoft;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String... args) {
        int totalCountOfMails = 1000;
        int mailsCountInThread = 200;

        List<Thread> threads = new ArrayList<>();
        for(int i=0; i<totalCountOfMails; i+=mailsCountInThread){
            int startIndex = i + 1;
            int endIndex = i + mailsCountInThread + 1;
            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            threads.add(thread);
            thread.start();
        }

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException("An error occurred while waiting for the thread to complete", e);
            }
        });
    }
}
