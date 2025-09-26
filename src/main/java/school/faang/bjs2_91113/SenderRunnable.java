package school.faang.bjs2_91113;

import lombok.AllArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;
    public static AtomicInteger counter = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println("Письмо отправлено");
            counter.incrementAndGet();
        }


    }
}
