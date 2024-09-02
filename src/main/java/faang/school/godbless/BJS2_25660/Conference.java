package faang.school.godbless.BJS2_25660;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.CyclicBarrier;

@Getter
@Setter
@ToString
public class Conference {
    private final String name;
    private final CyclicBarrier barrier;

    public Conference(String name, int participantCount) {
        this.name = name;
        barrier = new CyclicBarrier(participantCount, this::startStreaming);
    }

    public void waitForAllParticipants() {
        try {
            System.out.println(Thread.currentThread().getName() + " ждет других участников...");
            barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startStreaming() {
        System.out.println("Все участники присоединились. Конференция начинается!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
