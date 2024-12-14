package school.faang.task_44644;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum EventType {
    LUMOS("gives the light"),
    TRANSFIGURATION("transforms an item"),
    PROTECTION("protects from attacks"),
    EXPECTO_PATRONUM("repels Dementors");

    private final String description;

    EventType(String description) {
        this.description = description;
    }
}