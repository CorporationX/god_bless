package faang.school.godbless.zoom;

import java.util.concurrent.CountDownLatch;

public class Conference {
    private final CountDownLatch latch;

    public Conference(int requiredParticipants) {
        this.latch = new CountDownLatch(requiredParticipants);
    }

    public void participantArrived(String participantName) {
        System.out.println(participantName + " присоединился к конференции.");
        latch.countDown();
        System.out.println("Ожидаем еще " + latch.getCount() + " участников...");
    }

    public void startStreaming() throws InterruptedException {
        latch.await();
        System.out.println("Все участники присоединились! Трансляция начинается.");
    }
}

