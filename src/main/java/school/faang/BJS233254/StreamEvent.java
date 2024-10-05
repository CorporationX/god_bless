package school.faang.BJS233254;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StreamEvent {
    private int id;
    private String event;
    private String data;
}
