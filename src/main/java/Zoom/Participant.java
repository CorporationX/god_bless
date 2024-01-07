package Zoom;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.BrokenBarrierException;

@Getter
@AllArgsConstructor
public class Participant {
    private String name;

    public void joinConference(Conference conference) {
        try {
            Thread.sleep(1000);
            System.out.println("Пользователь " + name + " присоединился к конференции");
            conference.getCyclicBarrier().await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }

    }
}
