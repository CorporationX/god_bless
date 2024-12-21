package school.faang.bjs248049;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@AllArgsConstructor
public class SenderRunnable implements Runnable {

    private int startIndex;
    private int endIndex;
    private static final AtomicInteger emailCounter = new AtomicInteger(0);

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": started");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = startIndex; i < endIndex; i++) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            emailCounter.incrementAndGet();
            System.out.println("Email has sent: " + i);
        }
        System.out.println(Thread.currentThread().getName() + ": ended");
    }

    public static int getEmailCount() {
        return emailCounter.get();
    }

}
