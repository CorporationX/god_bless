package faang.school.godbless.Zoom;

import lombok.AllArgsConstructor;

import java.util.concurrent.BrokenBarrierException;

@AllArgsConstructor
public class Participant {
    private String name;

    public void joinConference(Conference conference) {
        System.out.println(name + " joined conference " + conference.getName());
        try {
            conference.getBarrier().await();
            conference.startStreaming();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}