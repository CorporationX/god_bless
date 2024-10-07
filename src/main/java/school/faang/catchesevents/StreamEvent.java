package school.faang.catchesevents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Data
@AllArgsConstructor
public class StreamEvent {
    private Integer id;
    private String eventType;
    private String data;

}
