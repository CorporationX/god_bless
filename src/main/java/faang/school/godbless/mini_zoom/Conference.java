package faang.school.godbless.mini_zoom;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Data
@Slf4j
public class Conference {
    private int totalMembers;
    private List<Participant> participants;
    private boolean isStreaming;
    private CyclicBarrier cyclicBarrier;

    public Conference(int totalMembers) {
        this.totalMembers = totalMembers;
        this.participants = new ArrayList<>();
        this.cyclicBarrier = new CyclicBarrier(totalMembers);
    }

    public void waitForConference() {
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }

        if (!isStreaming) {
            startStreaming();
        }
    }

    public void endStreaming() {
        participants = new ArrayList<>();
        cyclicBarrier.reset();
        log.info("The conference has finished!");
    }

    public void startStreaming() {
        isStreaming = true;
        log.info("The conference has begun!");
    }

    public void addParticipant(Participant participant) {
        if (!isStreaming) {
            participants.add(participant);
            participant.joinConference();
            waitForConference();
        } else {
            log.info("The conference is full");
        }
    }
}
