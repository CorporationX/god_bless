package school.faang.lovim_sobytiya;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@AllArgsConstructor
@Getter
@ToString
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;
}
