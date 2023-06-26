package Work_in_Microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        int numberMessages = 1000;
        int numberThreads = 5;
        int messagesPerThread = numberMessages/numberThreads;
        List<Thread> threads = new ArrayList<>(numberThreads);
        for (int i = 0; i < numberThreads; i++) {
            int startIndex = i * messagesPerThread + 1;
            int endIndex = startIndex + messagesPerThread - 1;
            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
            threads.add(i, new Thread(senderRunnable));
            threads.get(i).start();
        }
        threads.stream()
                .forEach(thread -> {
                    try {
                        thread.join();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                });
        System.out.println("All messages sent");
    }
}
