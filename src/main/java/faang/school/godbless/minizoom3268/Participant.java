package faang.school.godbless.minizoom3268;

import lombok.Getter;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;

@Getter
public class Participant {
    private int id;
    private static int counter;
    private static Random RANDOM = new Random();

    public Participant() {
        this.id = ++counter;
    }

    public void joinConference(Conference conference) {
        threadSleep(RANDOM.nextLong(7_000, 20_000));
        System.out.printf("Viewer #%d is ready. Waiting for others...%n", this.getId());
        barrierAwait(conference);
        conference.getCurrentViewersQuantity().addAndGet(1);
        System.out.printf("Viewer #%d has joined the conference%n", this.getId());
    }

    private void barrierAwait(Conference conference) {
        try {
            conference.getBarrier().await();
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
            Thread.currentThread().interrupt();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    private static void threadSleep(long timeInMillis) {
        try {
            Thread.sleep(timeInMillis);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
            Thread.currentThread().interrupt();
        }
    }
}
