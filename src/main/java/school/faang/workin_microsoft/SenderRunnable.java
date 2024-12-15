package school.faang.workin_microsoft;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            log.info("Email #{} was sent", i);
        }
    }
}
