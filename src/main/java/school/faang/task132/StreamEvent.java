package school.faang.task132;

import lombok.*;

import java.util.Date;


@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class StreamEvent {

    @Getter
    private int id;
    @Getter
    private String eventType;
    private String data;
}
