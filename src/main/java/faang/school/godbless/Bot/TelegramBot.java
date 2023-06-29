package faang.school.godbless.Bot;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.time.Duration;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class TelegramBot {
    private static final Integer REQUEST_LIMIT = 5;
    private Integer requestCounter = 0;
    @NonNull
    private LocalDateTime lastRequestTime;

    @SneakyThrows
    public void sendMessage(String message) {
        var time = LocalDateTime.now();
        var delta = Duration.between(lastRequestTime, time).getSeconds();
        if (delta < 1) {
            requestCounter++;
            if (requestCounter > REQUEST_LIMIT) {
                Thread.sleep(1000);
            }
        } else {
            requestCounter = 0;
            lastRequestTime = LocalDateTime.now();
        }
        System.out.println(message + " is sent");
    }
}
