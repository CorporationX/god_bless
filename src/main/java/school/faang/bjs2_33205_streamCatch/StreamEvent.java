package school.faang.bjs2_33205_streamCatch;

import lombok.Data;

@Data
public class StreamEvent {
    private final int id;
    private final String eventType;
    private final String data;
}
