package faang.school.godbless.MiniZoom;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@Slf4j
@Getter
public class Conference {
    private final String title;
    private final CyclicBarrier participantsCounter;
    private final List<Participant> participants = new ArrayList<>();
    private boolean isStarted = false;

    public Conference(String title, int participantsNeeded) {
        this.title = title;
        this.participantsCounter = new CyclicBarrier(participantsNeeded);
    }

    public void startStreaming() {
        isStarted = true;
        log.info("conference {} is starting now", title);
    }

    public void join(Participant participant) {
        synchronized (participants) {
            participants.add(participant);
            log.info("participant {} joined conference - {}", participant.getUserName(), title);
        }
        try {
            participantsCounter.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        startStreaming();
    }
}
