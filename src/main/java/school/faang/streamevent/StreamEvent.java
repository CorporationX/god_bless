package school.faang.streamevent;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
class StreamEvent {
    private final int id;
    private final String eventType;
    private final String data;
}
