package faang.school.godbless.MiniZoom;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@Data
@AllArgsConstructor
public class Participant {
    private String name;
    private CyclicBarrier barrier;

    public void joinConference(Conference conference) {
        try {
            Thread.sleep(new Random().nextInt(5) * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println(name + " ждёт начала стрима");
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name + " узрил начало");
    }
}
