package school.BJS2_39504;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Conference {

    private int requiredParticipants;
    private AtomicInteger countOfWaitingParticipants = new AtomicInteger(0);

    public Conference(int requiredParticipants) {
        this.requiredParticipants = requiredParticipants;
    }

    public void startStreaming() throws InterruptedException {
        System.out.println("Ожидания начала трансляции");
        synchronized (this) {
            while (countOfWaitingParticipants.get() < getRequiredParticipants()) {
                wait();
            }
        }
        System.out.println("Трансляция началась");
    }

    public void addCountOfParticipants() {
        synchronized (this) {
            countOfWaitingParticipants.incrementAndGet();
            notify();
        }
    }

    public void decrementCountOfParticipants() {
        countOfWaitingParticipants.decrementAndGet();
    }
}
