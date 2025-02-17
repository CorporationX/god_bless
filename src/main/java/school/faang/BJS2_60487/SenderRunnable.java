package school.faang.BJS2_60487;

import lombok.AllArgsConstructor;

import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

@AllArgsConstructor
public class SenderRunnable implements Runnable {

    private final String threadObjectName;
    private final int startIndex;
    private final int endIndex;
    private CopyOnWriteArrayList<String> messageBox;

    @Override
    public void run() {
        IntStream.range(startIndex, endIndex + 1)
                .forEach(i -> System.out.println(("Runnable object named %s, with startIndex: " +
                        "%d and endIndex: %d, send message: %s")
                        .formatted(threadObjectName, startIndex, endIndex,
                                Optional.ofNullable(messageBox.get(i)).orElse(""))));
    }
}
