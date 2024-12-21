package derschrank.sprint01.task07.bjstwo_44435;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class SpellEvent {
    private static int countOfEvents = 0;
    private final int id;
    private final Spell eventType;
    private final LocalDateTime dateTime;

    public SpellEvent(Spell spell) {
        this.id = ++countOfEvents;
        eventType = spell;
        dateTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return String.format("SpellEvent id: %d at %s. %s", id, getDateTimeStringStamp(), eventType);
    }

    public String getDescription() {
        return eventType.getDescription();
    }

    public String getDateTimeStringStamp() {
        return dateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    }

}
