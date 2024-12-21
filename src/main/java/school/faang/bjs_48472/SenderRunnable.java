package school.faang.bjs_48472;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

@Slf4j
@Getter
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;
    private int counter;

    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        IntStream.rangeClosed(startIndex, endIndex)
                .forEach(number -> {
                    counter++;
                    log.info("The email has been sent:\t{}", number);
                    log.info("The email has been processed:\t{}", counter);
                });
    }
}
