package school.BJS2_39504;

import java.util.concurrent.atomic.AtomicInteger;

public class Conference {

    private int requiredParticipants;
    private AtomicInteger countOfWaitingParticipants = new AtomicInteger(0);

    public Conference(int requiredParticipants) {
        this.requiredParticipants = requiredParticipants;
    }

    public void startStreaming() {
        System.out.println("Ожидания начала трансляции");
        while(true) {
            if(countOfWaitingParticipants.get() == requiredParticipants) {
                System.out.println("Трансляция началась");
                break;
            }
        }
    }

    public void addCountOfParticipants() {
        countOfWaitingParticipants.incrementAndGet();
    }
    public void decrementCountOfParticipants() {
        countOfWaitingParticipants.decrementAndGet();
    }
}
