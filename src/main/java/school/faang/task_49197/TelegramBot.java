package school.faang.task_49197;

import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
public class TelegramBot {
    public static final int REQUEST_LIMIT = 5;
    private volatile int requestCounter = 0;
    private LocalDateTime lastRequest = LocalDateTime.now();

    public synchronized void sendMessage(String message) {
        while (true){
            Duration deltaSendTime = Duration.between(lastRequest, LocalDateTime.now());

            if (deltaSendTime.toSeconds() < 1){
                requestCounter++;
            }
            else{
                requestCounter = 1;
            }

            if (requestCounter > REQUEST_LIMIT){
                try {
                    wait(1000);
                    continue;
                } catch (InterruptedException e) {
                    System.out.println("Ошибка выполнения потока");
                }
            }

            System.out.println("Отправка сообщения: " + message);
            lastRequest = LocalDateTime.now();
            break;
        }
    }
}
