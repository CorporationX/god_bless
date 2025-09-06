package school.faang.bjs2_85753;

import lombok.Getter;
import lombok.ToString;
import java.util.Objects;

@ToString

public class SpellEvent {
    private final int id;
    @Getter
    private final String eventType;
    @Getter
    private final String action;

    public SpellEvent(int id, String eventType, String action) {
        this.id = id;
        this.eventType = eventType;
        this.action = action;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        SpellEvent spellObject = (SpellEvent) obj;

        return eventType.equals(spellObject.eventType)
                && action.equals(spellObject.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventType, action);
    }
}
