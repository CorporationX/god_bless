package faang.school.godbless.concurrency.miniZoom;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CyclicBarrier;

@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Conference {
    int minMembersAmount = 10;
    CyclicBarrier barrier = new CyclicBarrier(minMembersAmount);
    String theme;
    Set<Participant> participants;


    public Conference(String theme) {
        this.theme = theme;
        participants = new HashSet<>();
    }

    public synchronized void startStreaming(Participant participant) {
        log.info("Participant " + participant.name() + " connected to conference.");
        log.info("Streaming is started.");
        participants.add(participant);
    }

    public String getTheme() {
        return theme;
    }

    public CyclicBarrier getBarrier() {
        return barrier;
    }

    public void showParticipants() {
        participants.forEach(System.out::println);
    }
}
