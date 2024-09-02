package faang.school.godbless.task.multithreading.concurrency.mini.zoom;

import lombok.Getter;

import java.util.List;
import java.util.stream.IntStream;

public class Configuration {
    @Getter
    private static final int NUMBER_OF_PARTICIPANT = 24;

    public List<Participant> getParticipants() {
        return IntStream
                .rangeClosed(1, NUMBER_OF_PARTICIPANT)
                .mapToObj(Participant::new)
                .toList();
    }

    public int getNumberOfParticipant() {
        return NUMBER_OF_PARTICIPANT;
    }
}
