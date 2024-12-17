package school.faang.sprint3.task_48327;

import lombok.RequiredArgsConstructor;

import java.util.stream.IntStream;

@RequiredArgsConstructor
public class SenderRunnable implements Runnable {

    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        IntStream.range(startIndex, endIndex).forEachOrdered(
                count -> System.out.printf("Message %d has been sent successfully !%n", count)
        );
    }
}
