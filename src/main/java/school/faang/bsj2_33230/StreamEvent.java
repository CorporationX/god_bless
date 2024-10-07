package school.faang.bsj2_33230;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;
}
