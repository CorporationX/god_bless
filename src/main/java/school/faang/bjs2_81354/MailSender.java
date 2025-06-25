package school.faang.bjs2_81354;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        List<SenderRunnable> senderList = List.of(new SenderRunnable(0, 199),
                new SenderRunnable(200, 399),
                new SenderRunnable(400, 599),
                new SenderRunnable(600, 799),
                new SenderRunnable(800, 999));

        List<Thread> threads = new ArrayList<>();
        for (SenderRunnable sender : senderList) {
            Thread thread = new Thread(sender,
                    "sending " + sender.getStartIndex() + "-" + sender.getEndIndex() + " letters");
            thread.start();
            threads.add(thread);
            log.info("Awaiting {}-{} letters...", sender.getStartIndex(), sender.getEndIndex());
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }
}
