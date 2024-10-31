package school.faang.miniZoom;

import lombok.Getter;

import java.util.concurrent.CountDownLatch;

@Getter
public class Conference {
    private final int requiredParticipants;
    private final CountDownLatch latch;

    public Conference(int requiredParticipants) {
        this.requiredParticipants = requiredParticipants;
        this.latch = new CountDownLatch(requiredParticipants);
    }

    public void startStreaming() {
        System.out.println("All participants have joined the conference. Streaming has started.");
    }
}
