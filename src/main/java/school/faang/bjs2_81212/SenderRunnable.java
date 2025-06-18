package school.faang.bjs2_81212;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static school.faang.bjs2_81212.MailSender.messageCounter;

@Slf4j
@RequiredArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            log.info("Письмо {} отправлено.", i);
            messageCounter.incrementAndGet();
        }
    }
}
