package school.faang.bjs2_72743;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MailSender {
    private static final int MAX_THREAD = 5;
    private static final int BATCH = 1000;

    public static void main(String[] args) {
        List<Thread> mailSenders = new ArrayList<>();
        for (int i = 0; i < MAX_THREAD; i++) {
            int startIndex = i * BATCH / MAX_THREAD + 1;
            int endIndex = startIndex + BATCH / MAX_THREAD - 1;
            log.debug("{} - {}", startIndex, endIndex);
            Thread mailSender = new Thread(new SenderRunnable(startIndex, endIndex));
            mailSender.start();
            mailSenders.add(mailSender);
        }

        for (Thread mailSender : mailSenders) {
            try {
                mailSender.join();
                log.info("mail sender [{}] is finish", mailSender.getName());
            } catch (InterruptedException e) {
                log.error("receive error from send email {}", e.getMessage(), e);
            }
        }
    }
}
