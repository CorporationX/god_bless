package school.faang.module1.bjs2_82980;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@Slf4j
@RequiredArgsConstructor
public class Conference {

    private final int requiredParticipants;
    private final CyclicBarrier barrier;

    public Conference(int requiredParticipants) {
        this.requiredParticipants = requiredParticipants;
        this.barrier = new CyclicBarrier(requiredParticipants, this::startStreaming);
    }

    public void awaitParticipant() {
        try {
            log.info("Участник присоединился. Ожидаем остальных...");
            barrier.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Поток прерван", e);
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            log.error("Ошибка барьера", e);
            throw new RuntimeException(e);
        }
    }

    public void startStreaming() {
        log.info("Все участники присоединились, начинаем трансляцию");
    }
}