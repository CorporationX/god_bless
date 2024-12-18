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

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": started");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println("Email has sent: " + i);
        }
        System.out.println(Thread.currentThread().getName() + ": ended");
    }

}
