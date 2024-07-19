package faang.school.godbless.multithreading.minizoom;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

@RequiredArgsConstructor
@Builder
public class Conference {

    private final CountDownLatch countDownLatch;
    private final int quantity;

    public CompletableFuture<Void> startStreaming(){
        System.out.println("Streaming will start soon...\n");
        return CompletableFuture.runAsync(() -> {
            try {
                countDownLatch.await();
                System.out.printf("All %d participants have already joined our stream.\n", quantity);
                System.out.println("We're starting stream...\n");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
