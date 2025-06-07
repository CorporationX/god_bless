package school.faang.bjs2_79723_booking_system.room;

import lombok.Getter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;


@ToString
@Getter
public class Room {
    private final int roomNumber;
    private final RoomType type;
    private Set<RoomAmenity> amenities;

    public Room(int roomNumber, RoomType type, Set<RoomAmenity> amenities) {
        if (type == null) {
            throw new IllegalArgumentException("Cannot create a room with empty type");
        }
        this.roomNumber = roomNumber;
        this.type = type;
        if (amenities != null) {
            this.amenities = new HashSet<>(amenities);
        }
    }
}
