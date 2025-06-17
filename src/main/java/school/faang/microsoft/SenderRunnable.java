package school.faang.microsoft;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private final int id;
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        System.out.printf("mail sender #%d is starting work...\n", id);
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.printf("letter number %s\n", i);
        }
    }
}
