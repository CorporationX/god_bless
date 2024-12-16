package school.faang.sprint3.bjs_48128;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class MailSender {
    public static void main(String[] args) {
        int totalEmails = 1000;
        int chunkOfEmails = 200;

        ExecutorService executor = Executors.newFixedThreadPool(5);
        int i = 0;
        while (i < totalEmails) {
            SenderRunnable sender = new SenderRunnable(i, i + chunkOfEmails - 1);
            executor.submit(sender);
            i += chunkOfEmails;
        }
        executor.shutdown();
    }
}
