package faang.school.godbless.mini_zoom;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Participant extends Thread {
    private final Conference conference;
    private final int participantNumber;

    public void joinConference() {
        try {
            Thread.sleep(2000);
            conference.participantArrived(participantNumber);
            conference.barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        joinConference();
    }
}
