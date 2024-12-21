package school.faang.task_48108;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static school.faang.task_48108.MailSender.EMAIL_SENDER_TIME;

@Slf4j
@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        for (int count = startIndex; count < endIndex; count++) {
            try {
                log.info("Письмо {} отправлено.", count);
                Thread.sleep(EMAIL_SENDER_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
