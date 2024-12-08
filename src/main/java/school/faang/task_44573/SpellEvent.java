package school.faang.task_44573;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class SpellEvent {
    private int id;
    private String eventType;
    private String eventDescription;

    @Builder
    public SpellEvent(Integer id, String eventType, String eventDescription) {
        if (id < 0) {
            throw new IllegalArgumentException("id mast be positive value");
        }

        if (eventType == null || eventType.isBlank()) {
            throw new IllegalArgumentException("event can not be string");
        }

        if (eventDescription == null || eventDescription.isBlank()) {
            throw new IllegalArgumentException("event can not be string");
        }

        this.id = id;
        this.eventType = eventType;
        this.eventDescription = eventDescription;
    }
}
