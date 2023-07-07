package faang.school.godbless.miniZoom;

import java.util.concurrent.BrokenBarrierException;

public class Participant implements Runnable{
    private static int participantCount = 0;
    private final int id;
    private final Conference conference;

    public Participant(Conference conference) {
        this.id = ++participantCount;
        this.conference = conference;
    }

    public void joinConference() throws InterruptedException, BrokenBarrierException {
        System.out.println("Participant " + id + " joined the conference");
        conference.participantArrived();
    }

    @Override
    public void run() {
        try {
            joinConference();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

}
