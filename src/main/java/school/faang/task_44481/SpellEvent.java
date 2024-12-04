package school.faang.task_44481;

import lombok.Data;
import lombok.NonNull;

@Data
public class SpellEvent {
    private final int id;
    @NonNull
    private String eventType;
    @NonNull
    private String action;
}
