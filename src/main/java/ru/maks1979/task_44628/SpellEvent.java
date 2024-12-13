package ru.maks1979.task_44628;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpellEvent {
    private int id;
    private String eventType;
    private String action;

    public SpellEvent(int id, String eventType, String action) {
        this.id = id;
        this.eventType = eventType;
        this.action = action;
    }

    public String toString() {
        return "SpellEvent{id=" + id + ", eventType='" + eventType + "', actionDescription='" + action + "'}";
    }
}

