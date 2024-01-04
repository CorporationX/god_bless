package faang.school.godbless.multithreading.volotileImmutable.miniZoom;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@Getter
@AllArgsConstructor
public class Conference {
    private static final int REQUIRED_AMOUNT_PEOPLE = 5;
    private static final CyclicBarrier BARRIER = new CyclicBarrier(REQUIRED_AMOUNT_PEOPLE);

    private final String name;

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < REQUIRED_AMOUNT_PEOPLE; i++) {
            Thread thread = new Thread(new Participant("Participant - " + (i + 1)));
            threads.add(thread);
            thread.start();
        }

        threads.forEach(tr -> {
            try {
                tr.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        startStreaming();
    }

    public static void startStreaming() {
        System.out.println("Stream has started!");
    }

    @Getter
    @AllArgsConstructor
    static class Participant implements Runnable {
        private String name;

        public void joinConference() {
            System.out.println(name + " joined to conference!");
        }

        @Override
        public void run() {
            System.out.println(name + " wants to join conference");

            try {
                BARRIER.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            joinConference();
        }
    }
}


