package school.faang.BJS2_33283;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor
public class StreamEvent {

    private int id;
    private String eventType;
    private String data;
}
