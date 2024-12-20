package school.faang.bjs248406;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Getter
public class SenderRunnable implements Runnable {
    private static final AtomicInteger COMPLETED_THREAD_COUNTER = new AtomicInteger(0);
    private int startIndex;
    private int finishIndex;

    @Override
    public void run() {
        System.out.println("Letter is " + startIndex + " to " + finishIndex + " is sent successfully!");
        COMPLETED_THREAD_COUNTER.incrementAndGet();
    }

    public static boolean allThreadsCompleted(int totalTread) {
        return COMPLETED_THREAD_COUNTER.get() == totalTread;
    }

    public static void resetCounterThread() {
        COMPLETED_THREAD_COUNTER.set(0);
    }
}
