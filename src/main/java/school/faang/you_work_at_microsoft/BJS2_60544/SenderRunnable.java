package school.faang.you_work_at_microsoft.BJS2_60544;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
@Getter
public class SenderRunnable implements Runnable {
    private static final Logger log = LoggerFactory.getLogger(SenderRunnable.class);

    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            log.info("Письмо отправлено");
        }
    }
}
