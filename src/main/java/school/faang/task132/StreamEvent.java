package school.faang.task132;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
@Data
@ToString
@AllArgsConstructor
public class StreamEvent {

    private int id;
    private String eventType;
    private String data;
}
