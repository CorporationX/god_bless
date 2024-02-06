package faang.school.godbless.mini_zoom;

import lombok.Getter;

import java.util.Random;
import java.util.concurrent.*;

public class Main {
    private static final int NUMBER_OF_PARTICIPANTS = 8;
    private static final ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_PARTICIPANTS);
    private static final CyclicBarrier BARRIER = new CyclicBarrier(NUMBER_OF_PARTICIPANTS);

    public static void main(String[] args) {
        Conference conference = new Conference();

        for (int i = 1; i < NUMBER_OF_PARTICIPANTS + 1; i++) {
            int finalI = i;
            executor.execute(() -> {
                String name = "Participaint-" + finalI;
                try {
                    Thread.sleep(new Random().nextInt(1, 7) * 1000L);
                    System.out.println(name + " ожидает начала трансляции");
                    BARRIER.await(10, TimeUnit.SECONDS);
                } catch (InterruptedException | BrokenBarrierException | TimeoutException e) {
                    e.printStackTrace();
                }
                conference.startStreaming();
            });
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(12, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

@Getter
class Conference {
    public void startStreaming() {
        System.out.println("Трансляция началась!" + Thread.currentThread().getName());
    }
}

//Сначала сделал по обычному, потом сократил.
// Сделал через executor. и убрал класс Participant, тк как у него одно поле name и два метода которые можно передать в лямбде!
// Если так не канает, вернете пределаю!

//@Getter
//@AllArgsConstructor
//class Participant implements Runnable {
//    private static final int NUMBER_OF_PARTICIPANTS = 8;
//    private static final CyclicBarrier BARRIER = new CyclicBarrier(NUMBER_OF_PARTICIPANTS);
//    private String name;
//
//    public void joinConference()  {
//        System.out.println("Все собрались, запускаем!");
//
//    }
//
//    @Override
//    public void run() {
//
//        try {
//            BARRIER.await();
//        } catch (InterruptedException |
//                 BrokenBarrierException e) {
//            e.printStackTrace();
//        }
//    }
//}
