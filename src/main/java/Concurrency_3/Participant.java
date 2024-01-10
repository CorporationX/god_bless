package Concurrency_3;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Participant {

    String name;

    public Participant(String name) {
        this.name = name;
    }

    public void joinConference(CyclicBarrier barrier) {
        System.out.println("Participant " + getName() + " connect to stream");
        try {
            barrier.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    public String getName() {
        return name;
    }
}
