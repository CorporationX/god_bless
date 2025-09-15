package school.faang.module3.microsoft;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex + 1; i++) {
            System.out.printf("Письмо %s отправлено%n", i);
        }
    }
}
