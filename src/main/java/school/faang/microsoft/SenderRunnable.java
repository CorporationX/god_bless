package school.faang.microsoft;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.printf("Письмо %4d отправлено потоком %s%n", i, Thread.currentThread().getName());
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.printf("Поток %s был прерван: %s%n", Thread.currentThread().getName(), e.getMessage());
            }
        }
    }
}