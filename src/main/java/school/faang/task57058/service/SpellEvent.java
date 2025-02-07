package school.faang.task57058.service;

import lombok.Data;

@Data
public class SpellEvent {
    private static int nextId = 1;
    private final int id;
    private final String eventType;
    private final String action;

    public SpellEvent(int id, String eventType, String action) {
        this.id = nextId++;
        this.eventType = eventType;
        this.action = action;
    }
}
