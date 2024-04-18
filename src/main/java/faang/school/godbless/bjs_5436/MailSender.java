package faang.school.godbless.bjs_5436;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MailSender {

    private static final int MAIL_COUNT = 1000;
    private static final int BANCH_SIZE = 200;

    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();

        int end = BANCH_SIZE;
        for (int start = 1; end < MAIL_COUNT; start = end + 1) {
            end = start + BANCH_SIZE - 1;
            Thread thread = new Thread(new SenderRunnable(start, end));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        }

        log.info("All mails were sent");
    }
}
