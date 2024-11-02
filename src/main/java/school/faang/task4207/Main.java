package school.faang.task4207;

import java.util.concurrent.*;
import java.util.Random;

class Conference {
    private final int requiredParticipants;
    private final CyclicBarrier barrier;

    public Conference(int requiredParticipants) {
        this.requiredParticipants = requiredParticipants;
        this.barrier = new CyclicBarrier(requiredParticipants, this::startStreaming);
    }

    public void participantJoined() {
        try {
            System.out.println("Участник присоединился. Осталось ждать: " + (barrier.getNumberWaiting() + 1) + " участников.");
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void startStreaming() {
        System.out.println("Все участники присоединились. Начинается трансляция!");
    }
}

class Participant implements Runnable {
    private final Conference conference;

    public Participant(Conference conference) {
        this.conference = conference;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(2000)); // Симуляция времени подключения участника
            conference.participantJoined();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int requiredParticipants = 5;
        Conference conference = new Conference(requiredParticipants);

        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < requiredParticipants; i++) {
            executor.submit(new Participant(conference));
        }

        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Завершение работы приложения");
    }
}

