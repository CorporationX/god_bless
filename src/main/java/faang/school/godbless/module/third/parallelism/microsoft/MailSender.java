package faang.school.godbless.module.third.parallelism.microsoft;

import java.util.List;
import java.util.stream.Stream;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int mailsPartition = 200;
        int threadCount = 5;
        
        List<Thread> threads = Stream.iterate(0, (partitionSize) -> partitionSize + mailsPartition)
            .map((partitionSize) -> new Thread(new SenderRunnable(partitionSize, partitionSize + mailsPartition)))
            .limit(threadCount)
            .peek((thread) -> thread.start())
            .toList();
        for (Thread thread : threads) {
            thread.join();
        }
        
        System.out.println("Все сообщения успешно отправлены");
    }
}
