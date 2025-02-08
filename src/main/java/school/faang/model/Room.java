package school.faang.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import java.util.Set;

@Getter
@RequiredArgsConstructor
@ToString
public class Room {
    private final int roomNumber;
    private final String type;
    private final Set<String> amenities;
}
