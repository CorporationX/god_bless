package school.faang.BJS2_60487;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.IntStream;

@AllArgsConstructor
public class SenderRunnable implements Runnable {

    private final String threadObjectName;
    private final int startIndex;
    private final int endIndex;
    private final ArrayList<String> messageBox;
    private static final String MESSAGE_TEMPLATE =
            "Runnable object named %s, with startIndex: %d\n" +
            "and endIndex: %d, send message: %s";

    @Override
    public void run() {
        IntStream.range(startIndex, endIndex + 1)
                .forEach(i -> System.out.println(MESSAGE_TEMPLATE
                        .formatted(threadObjectName, startIndex, endIndex,
                                Optional.ofNullable(messageBox.get(i)).orElse(""))));
    }
}
