package school.faang.sprint_3.work_in_microsoft;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        log.info("Message sent");
    }
}
