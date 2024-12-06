package school.faang.bjs244617;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class SpellEvent {
    private int id;

    @NonNull
    private SpellType eventType;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SpellEvent{");
        sb.append("id=").append(id);
        sb.append(", eventType='").append(eventType).append('\'');
        sb.append(", action='").append(eventType.getAction()).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @AllArgsConstructor
    @Getter
    public enum SpellType {
        CHARMS("charms"),
        TRANSFIGURATION("transfiguration"),
        PROTECTION("protection");

        private final String action;
    }
}
