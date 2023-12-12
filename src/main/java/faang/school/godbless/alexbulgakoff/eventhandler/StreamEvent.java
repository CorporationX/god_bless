package faang.school.godbless.alexbulgakoff.eventhandler;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Alexander Bulgakov
 */
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class StreamEvent {

    private Integer id;

    private String eventType;

    private String data;
}
