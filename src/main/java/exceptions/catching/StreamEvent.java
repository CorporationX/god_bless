package exceptions.catching;

import lombok.Data;
import lombok.NonNull;

@Data
public class StreamEvent {
    private final int id;
    @NonNull
    private final String eventType;
    @NonNull
    private final String data;
}
