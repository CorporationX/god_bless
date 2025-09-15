package school.faang.bjs2_89556;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

import java.util.regex.Pattern;


@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private static final long TIME_SEND_LETTER = 10;
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            try {
                Thread.sleep(TIME_SEND_LETTER);
                System.out.printf("letter %d sent \n", i);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}
