package faang.school.godbless.javaHashMap.cathcingEvents;

import lombok.Data;
import lombok.NonNull;

@Data
public class StreamEvent {
    @NonNull
    private Integer id;
    @NonNull
    private String eventType;
    @NonNull
    private String data;
}
