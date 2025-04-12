package school.faang.booking;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public class Room {
    private final int roomNumber;
    private final String type;
    private final Set<String> amenities;
}