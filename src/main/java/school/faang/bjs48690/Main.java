package school.faang.bjs48690;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Main {
    public static final int THREAD_MAX_LETTERS = 200;
    public static final int TOTAL_LETTERS = 1000;

    public static void main(String[] args) {
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < TOTAL_LETTERS; i += THREAD_MAX_LETTERS) {
            Thread thread = new Thread(new SenderRunnable(i, i + THREAD_MAX_LETTERS - 1));
            threadList.add(thread);
            thread.start();
        }

        threadList.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("Error while joining to main {}", e.getMessage());
            }
        });

        System.out.println("Finished sending");
    }
}
