package school.faang.eventtask_BJS2_33278;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StreamEvent {

    private int id;
    private String eventType;
    private String data;
}
