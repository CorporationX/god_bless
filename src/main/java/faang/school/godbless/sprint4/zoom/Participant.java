package faang.school.godbless.sprint4.zoom;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Participant implements Runnable {
    private Conference conference;

    public void joinConference() {
        conference.participantArrived();
    }

    @Override
    public void run() {
        joinConference();
    }
}
