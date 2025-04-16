package school.faang.stream1.bookingsystem;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
@Getter
public class Room {
    private final int roomNumber;

    private final String type;

    private final Set<String> amenities;
}
