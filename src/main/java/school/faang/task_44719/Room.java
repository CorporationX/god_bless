package school.faang.task_44719;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
public class Room {
    private int roomId;
    private final String type;
    private final Set<String> amenities;
}
