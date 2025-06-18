package school.faang.microsoft;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Danil Pudovkin
 * @since 16.06.2025
 */
@Slf4j
@RequiredArgsConstructor
public class SenderRunnable implements Runnable {

    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            log.info("Письмо %d отправлено".formatted(i));
        }
    }
}
