package school.faang.task49909;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.LongStream;

@Slf4j
public class Main {
    private static final long RANGE_END = 1000;

    public static void main(String[] args) {
        launch();
    }

    private static void launch() {
        String sum = ResultConsumer.fanOutFanIn(LongStream.rangeClosed(1, RANGE_END).boxed()
                .map(SquareRequest::new).toList(), new ResultConsumer(new AtomicLong(0L))).toString();

        log.info(sum);
    }
}
