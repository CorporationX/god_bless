package school.faang.sprintone.catchevent;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SpellEvent {
    private final int id;
    private final String eventType;
    private final String action;

    @Override
    public String toString() {
        return "ID: " + id + ", Type: " + eventType + ", Action: " + action;
    }
}
