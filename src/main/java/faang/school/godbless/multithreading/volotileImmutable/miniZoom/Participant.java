package faang.school.godbless.multithreading.volotileImmutable.miniZoom;

import lombok.Getter;

import java.util.concurrent.BrokenBarrierException;

@Getter
public class Participant implements Runnable {
    private final String name;
    private final Conference conference;

    public Participant(String name, Conference conference) {
        this.name = name;
        this.conference = conference;
    }

    public void joinConference() {
        System.out.println(name + " joined to conference!");
    }

    @Override
    public void run() {
        joinConference();
        try {
            conference.getBARRIER().await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
