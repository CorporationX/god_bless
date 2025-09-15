package school.faang.handlers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@Getter
@ToString
public class SpellEvent {
    private static int currentId = 1;

    private int id;
    private String eventType;
    private String action;

    public SpellEvent(@NotNull String eventType, @NotNull String action) {
        this.id = currentId++;
        this.eventType = eventType;
        this.action = action;
    }
}