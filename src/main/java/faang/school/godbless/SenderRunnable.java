package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SenderRunnable implements Runnable{
    int startIndex;
    int endIndex;
    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            // Логика отправки письма (в данном случае просто вывод сообщения)
            System.out.println("Message " + i + " sent successfully by " + Thread.currentThread().getName());
        }
    }
}
