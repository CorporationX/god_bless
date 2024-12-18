package school.faang.sprint3.task_48452;

import lombok.RequiredArgsConstructor;

import java.util.stream.IntStream;

@RequiredArgsConstructor
public class SenderRunnable implements Runnable {

    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        IntStream.range(startIndex, endIndex)
                .forEach((i) -> System.out.println("Message number: " + i + " was sent"));
    }
}
