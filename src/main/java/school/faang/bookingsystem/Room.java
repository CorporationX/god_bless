package school.faang.bookingsystem;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Set;

@RequiredArgsConstructor
@ToString
@Getter
@EqualsAndHashCode
public class Room {
    private final int roomNumber;
    private final String type;
    private final Set<String> amenities;
}
