package faang.school.godbless.concur3;

import java.util.concurrent.BrokenBarrierException;

public record Participant(String name) {

    private static final String MESSAGE_JOINED_CONFERENCE = " - присоединился к конференции";

    public void joinConference() {
        System.out.println(name + MESSAGE_JOINED_CONFERENCE);
        try {
            Conference.barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        Conference.startStreaming(name);
    }
}
