package school.faang.catch_events;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Random;

@Getter
@Setter
public class SpellEvent {
    private int id;
    private String eventType;
    private String action;
    private static final int RANDOM_SEED = 9999;

    public SpellEvent(String eventType, String action) {
        this.eventType = eventType;
        this.action = action;
        this.id = createId();
    }

    private int createId() {
        Random rand = new Random();
        return rand.nextInt(RANDOM_SEED);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        SpellEvent otherProduct = (SpellEvent) otherObject;
        return this.id == otherProduct.getId()
                && this.eventType.equals(otherProduct.getEventType())
                && this.action.equals(otherProduct.getAction());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventType, action);
    }

    @Override
    public String toString() {
        return "\n--- Spell with ID: " + id + "---"
                + "\nEvent type: " + eventType
                + "\nAction: " + action;
    }
}
