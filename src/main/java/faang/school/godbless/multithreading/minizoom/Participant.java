package faang.school.godbless.multithreading.minizoom;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

import static java.lang.Thread.*;

@RequiredArgsConstructor
public class Participant {

    private final String name;
    private final CountDownLatch countDownLatch;

    public CompletableFuture<Void> joinConference(){
       return CompletableFuture.runAsync(() -> {
           try {
               sleep(1500L);
               System.out.printf("Participant %s is joined to the stream.\n", name);
               countDownLatch.countDown();
           } catch (InterruptedException e) {
               Thread.currentThread().interrupt();
               throw new RuntimeException(e);
           }
       });
    }
}
