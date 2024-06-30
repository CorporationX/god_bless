package faang.school.godbless.concur3;

import java.util.concurrent.CyclicBarrier;

public record Conference(int minimumParticipants) {
    private static final String MESSAGE_START_CONFERENCE = "У %s началась трансляция конференции\n";
    public static CyclicBarrier barrier;

    public Conference(int minimumParticipants) {
        this.minimumParticipants = minimumParticipants;
        barrier = new CyclicBarrier(minimumParticipants);
    }

    public static void startStreaming(String nameParticipant) {
        System.out.format(MESSAGE_START_CONFERENCE, nameParticipant);
    }
}
