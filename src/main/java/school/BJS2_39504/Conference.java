package school.BJS2_39504;

import java.util.concurrent.CountDownLatch;

public class Conference {

    public int requiredParticipants;
    private CountDownLatch latch;

    public Conference(int requiredParticipants) {
        this.requiredParticipants = requiredParticipants;
        latch = new CountDownLatch(requiredParticipants);
    }

    public void startStreaming() {
        System.out.println("Ожидаем подключения слушателей");
        try {
            latch.await();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Трансляция началась");
    }

    public synchronized void countDawn() {
        latch.countDown();
    }

}
