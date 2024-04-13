package faang.school.godbless.BJS2_4283;

import lombok.Getter;
import lombok.ToString;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Getter
@ToString
public class StreamEvent {
    private static final Set<Integer> ID = new HashSet<>();

    private Integer id;
    private String eventType;
    private String data;

    public StreamEvent(String eventType, String data) {
        validateData(eventType, data);
        this.id = generateId();
        this.eventType = eventType;
        this.data = data;
    }

    private Integer generateId() {
        Integer nextID = ID.isEmpty() ? 1 : Collections.max(ID) + 1;
        ID.add(nextID);
        return nextID;
    }

    private void validateData(String eventType, String data) {
        if (eventType.isBlank() || data.isBlank()) {
            throw new IllegalArgumentException("Invalid data");
        }
    }
}
