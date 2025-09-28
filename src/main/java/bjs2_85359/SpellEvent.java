package bjs2_85359;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SpellEvent {
    private final int id;
    public final String eventType;
    private final String action;

    @Override
    public String toString() {
        return "ID: " + id + ", Тип: " + eventType + ", Действие: " + action;
    }

}
