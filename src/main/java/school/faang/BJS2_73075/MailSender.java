package school.faang.BJS2_73075;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import static school.faang.BJS2_73075.Constants.MAILS_COUNT;
import static school.faang.BJS2_73075.Constants.THREADS_COUNT;

@Slf4j
public class MailSender {

    public static void main(String[] args) {
        int batchSize = MAILS_COUNT / THREADS_COUNT;
        int startMailIndex = 1;
        int endMailIndex = startMailIndex + batchSize;
        List<Thread> threads = new ArrayList<>();
        for (int i  = 0; i < THREADS_COUNT; i++) {
            Thread thread = new Thread(new SenderRunnable(startMailIndex, endMailIndex));
            thread.start();
            threads.add(thread);
            startMailIndex = endMailIndex;
            endMailIndex += batchSize;
        }
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        log.info("Mail sending has finished successfully!");
    }
}
