package school.faang.BJS2_79716;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Room {
    private final int roomNumber;
    private final String type;
    private final Set<String> amenities;
}
