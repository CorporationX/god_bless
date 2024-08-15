package faang.school.godbless.Maps.BJS2_20507;

import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.ThreadLocalRandom;

@ToString
@Getter
public class StreamEvent {
    private final int id;
    private final String eventType;
    private String data;

    public StreamEvent(String eventType) {
        this.id = ThreadLocalRandom.current().nextInt(1, 10000);
        this.eventType = eventType;
    }
}