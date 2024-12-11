package school.faang.bjs244740;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Room {
    private final int roomId;
    private final String type;
    private final Set<String> amenities;
}
