package work.at.microsoft;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            MailSender.counter.incrementAndGet();
            System.out.printf("Your message no: %d has ben successfully sent!%n", i);
        }
        log.info("All messages from thread has ben successfully sent!");
    }
}
