package faang.school.godbless.Bot;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.time.Duration;
import java.time.Instant;

@RequiredArgsConstructor
@Getter
public class TelegramBot {
    private static final Integer REQUEST_LIMIT = 5;
    private Integer requestCounter = 0;
    @NonNull
    private Instant lastRequestTime;

    @SneakyThrows
    public synchronized void sendMessage(String message) {
        var time = Instant.now();
        var delta = Duration.between(lastRequestTime, time);
        if (delta.getSeconds() < 1) {
            requestCounter++;
            if (requestCounter > REQUEST_LIMIT) {
                Thread.sleep(Duration.ofSeconds(1).minus(delta).toMillis());
            }
        } else {
            requestCounter = 0;
            lastRequestTime = Instant.now();
        }
        System.out.println(message + " is sent");
    }
}
