package school.faang.microsoft;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;
    private AtomicInteger totalSent;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println("Письмо отправлено " + i + " " + Thread.currentThread().getName());
            totalSent.incrementAndGet();
        }
    }
}
