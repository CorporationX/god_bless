package school.faang.sprint3.task_48327;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

@RequiredArgsConstructor
@Slf4j
public class SenderRunnable implements Runnable {

    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        IntStream.range(startIndex, endIndex).forEachOrdered(
                count -> log.info("Message {} has been sent successfully !", count)
        );
    }
}
