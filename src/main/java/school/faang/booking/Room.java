package school.faang.booking;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@EqualsAndHashCode
@ToString
public class Room {
    private static final AtomicInteger idCounter = new AtomicInteger(1);

    private final int roomNumber;
    private final String type;
    private final Set<String> amenities;

    public Room(String type, Set<String> amenities) {
        this.roomNumber = idCounter.getAndIncrement();
        this.type = type;
        this.amenities = amenities;
    }
}
