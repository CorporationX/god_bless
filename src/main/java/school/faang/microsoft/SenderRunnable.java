package school.faang.microsoft;

import lombok.Data;

@Data
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            // Логика отправки письма
            System.out.println("Письмо отправлено: " + i);
        }
    }
}
