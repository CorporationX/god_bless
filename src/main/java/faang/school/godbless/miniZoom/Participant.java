package faang.school.godbless.miniZoom;

import lombok.AllArgsConstructor;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@AllArgsConstructor
public class Participant {
    private String name;

    public void joinConference(Conference conference) {
        System.out.println(name + " joined conference " + conference.getName());
        try {
            conference.getCyclicBarrier().await(5, TimeUnit.MINUTES);
        } catch (InterruptedException | BrokenBarrierException | TimeoutException e) {
            System.out.println("Conference was canceled. Not all participants joined");
        }
    }
}
