package faang.school.godbless.zoom;

import lombok.Getter;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

public class Conference {
    private static final int USERS_FOR_START = 2;
    private final CopyOnWriteArrayList<Participant> participants;
    @Getter
    private CountDownLatch countDownLatch;

    public Conference() {
        participants = new CopyOnWriteArrayList<>();
        countDownLatch = new CountDownLatch(USERS_FOR_START);
    }

    public void joinConf(Participant participant) {
        participants.add(participant);
        countDownLatch.countDown();

        System.out.println(participant.name() + " joined");

        participant.joinConference(this);
    }

    public void startStreaming() {
        System.out.println("translation started");
    }
}
