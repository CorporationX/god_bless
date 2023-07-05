package faang.school.godbless.Sprint4.Task_14_TelegramBot;

import java.time.Instant;

public class TelegramBot {
    private final int REQUEST_LIMIT;
    private int requestCounter;
    private Instant lastRequestTime;

    public TelegramBot() {
        this.REQUEST_LIMIT = 5;
        this.requestCounter = 0;
        this.lastRequestTime = Instant.now();
    }
}
