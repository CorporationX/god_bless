package school.faang.task49909;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public record ResultConsumer(AtomicLong sumOfSquaredNumbers) {

    public Long add(final Long num) {
        return sumOfSquaredNumbers.addAndGet(num);
    }

    public Long getSum() {
        return sumOfSquaredNumbers.get();
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        CompletableFuture.allOf(requests.stream()
                        .parallel()
                        .map(request -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer))
                                .thenRun(() -> log.info(request.number().toString())))
                        .toArray(CompletableFuture[]::new))
                .join();

        return resultConsumer.getSum();
    }
}
