package school.faang.bjs2_81766_matters_of_heart;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Getter
@Slf4j
public class Chat {
    private static final int MIN_CHAT_DURATION_SEC = 3;
    private static final int MAX_CHAT_DURATION_SEC = 10;

    private final User user1;
    private final User user2;


    public Chat(@NonNull User user1, @NonNull User user2) {
        this.user1 = user1;
        this.user2 = user2;
    }

    public synchronized void begin() {
        user1.setLookingForChat(false);
        user2.setLookingForChat(false);
        log.info("Chat begin for {} and {}", user1.getName(), user2.getName());
    }

    public void doChatting() {
        try {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(MIN_CHAT_DURATION_SEC, MAX_CHAT_DURATION_SEC));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public synchronized void end() {
        user1.setLookingForChat(true);
        user2.setLookingForChat(true);
        log.info("Chat ended for {} and {}", user1.getName(), user2.getName());
    }
}
