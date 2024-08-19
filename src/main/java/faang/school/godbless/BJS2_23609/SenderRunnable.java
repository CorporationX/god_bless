package faang.school.godbless.BJS2_23609;

import lombok.RequiredArgsConstructor;

import java.util.stream.IntStream;

@RequiredArgsConstructor
public class SenderRunnable implements Runnable {
    private final Integer startIndex;
    private final Integer endIndex;

    @Override
    public void run() {
        IntStream.range(startIndex, endIndex)
                .forEach(index -> System.out.printf(
                        "Letter %d was sent from thread №%d.\n", index, Thread.currentThread().getId())
                );
    }
}
