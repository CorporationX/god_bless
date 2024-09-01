package faang.school.godbless.Zoom;

import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Slf4j
public class Conference {
    private final String id;
    private final String title;
    private final String location;
    private final int minRequiredParticipantsToStartStreaming;
    private final List<Participant> participants = new ArrayList<>();
    private final Object liveLock = new Object();
    private boolean isStarting = false;

    public Conference(@NonNull String title, String location, int minRequiredParticipantsForStreaming) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.location = location;
        this.minRequiredParticipantsToStartStreaming = minRequiredParticipantsForStreaming;
    }

    public void addParticipant(Participant participant) {
        synchronized (liveLock) {
            participants.add(participant);

            if (isStarting) {
                log.info("{} is joining the ongoing conference", participant.getName());
            } else {
                log.info("{} is waiting for the streaming to start", participant.getName());
            }

            if (!isStarting && participants.size() >= minRequiredParticipantsToStartStreaming) {
                liveLock.notifyAll();
            }
        }
    }

    public void startStreaming() {
        synchronized (liveLock) {
            while (participants.size() < minRequiredParticipantsToStartStreaming) {
                try {
                    liveLock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("Streaming was interrupted: {}", e.getMessage());
                }
            }
            isStarting = true;
            log.info("Starting streaming for {} participants", participants.size());
            participants.forEach(Participant::joinConference);
        }
    }
}