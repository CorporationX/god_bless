package faang.school.godbless;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int totalMessages = 1000;
        int threadsCount = 5;
        int messagesPerThreads = totalMessages / threadsCount;

        ExecutorService executorService = Executors.newFixedThreadPool(threadsCount);

        for(int i =0; i < threadsCount; i++){
            int startIndex = i * messagesPerThreads + 1;
            int endIndex = (i + 1) * messagesPerThreads;

            if(i == threadsCount -1){
                endIndex += totalMessages % threadsCount;
            }
            SenderRunnable sender = new SenderRunnable(startIndex, endIndex);
            executorService.execute(sender);
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
            Thread.sleep(1000);
            System.out.println("WAITING");
        }

        System.out.println("Все письма успешно отправлены.");
    }
}
