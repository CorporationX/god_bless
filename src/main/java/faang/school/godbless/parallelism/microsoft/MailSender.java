package faang.school.godbless.parallelism.microsoft;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MailSender {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        for(int i = 0; i <= 8; i++) {
            threads.add(new Thread(new SenderRunnable(i, i+ 199)));
        }

        log.info("Starting mail processing.");

        try {
            for (Thread thread : threads) {
                thread.start();
                thread.join();
            }
        } catch (InterruptedException e) {
            log.error("During mail processing was thrown an exception.", e);
        }
        log.info("Mail was fully proceed.");
    }
}
