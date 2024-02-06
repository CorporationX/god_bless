package miniZoom_1379;

import lombok.Data;

import java.util.concurrent.BrokenBarrierException;

@Data
public class Participant {

    private int id;
    private static int count = 0;

    public Participant() {
        this.id = ++count;
    }

    public void joinConference(Conference conference) {
        try {
            System.out.printf("Участник %s присоединился к конференции \n", id);
            Thread.sleep(3000);
            conference.getBarrier().await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (BrokenBarrierException e) {
            Thread.currentThread().interrupt();
            System.out.println("Трансляция прервана");
        }
    }
}