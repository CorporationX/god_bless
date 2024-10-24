package school.faang.BJS2_37903_SendRaven;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public class Kingdom {
    private static final int SENDING_MESSAGE_TIME = 3_000;

    private String name;

    public String sendMessage(Kingdom kingdom) {
        try {
            Thread.sleep(SENDING_MESSAGE_TIME);
            return String.format("Kingdom %s sent message to kingdom %s", name, kingdom.getName());
        } catch (InterruptedException e) {
            handleInterruptedException(kingdom, e);
            return null;
        }
    }

    private void handleInterruptedException(Kingdom kingdom, InterruptedException e) {
        log.error(
                "Thread {} was interrupted while sending message from {} to {}!",
                Thread.currentThread().getName(), name, kingdom.getName(), e
        );
        throw new IllegalStateException(
                String.format("Thread %s was interrupted while sending message from %s to %s!",
                        Thread.currentThread().getName(), name, kingdom.getName()
                ),
                e
        );
    }
}
