package school.faang.bjs2_72743;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MailSender {
    private static final int MAX_EMAIL = 1000;
    private static final int PORTIONS = 200;

    public static void main(String[] args) {
        List<Thread> mailSenders = new ArrayList<>();
        int startIndex = 1;
        int endIndex = PORTIONS;
        while (endIndex <= MAX_EMAIL) {
            Thread mailSender = new Thread(new SenderRunnable(startIndex, endIndex));
            mailSender.start();
            mailSenders.add(mailSender);
            startIndex = endIndex + 1;
            endIndex += PORTIONS;
        }

        for (Thread mailSender : mailSenders) {
            try {
                mailSender.join();
            } catch (InterruptedException e) {
                log.error("receive error from send email {}", e.getMessage(), e);
            }
        }
    }
}
