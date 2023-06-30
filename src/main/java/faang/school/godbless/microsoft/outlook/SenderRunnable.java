package faang.school.godbless.microsoft.outlook;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;


@Data
@Slf4j
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.printf(
                "CurrentThread [name: %s, id: %d] Sending mail: %d%n",
                Thread.currentThread().getName(), Thread.currentThread().getId(), i
            );
        }
        log.debug("sent mails batch: " + Thread.currentThread().getName());
    }
}
