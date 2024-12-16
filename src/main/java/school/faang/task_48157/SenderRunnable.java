package school.faang.task_48157;

import lombok.RequiredArgsConstructor;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        IntStream.range(startIndex, endIndex)
                .forEach(i -> System.out.println("Письмо отправлено: " + i));
    }
}