package school.faang.bjs2_79723_booking_system;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;


@ToString
@Getter
public class Room {
    public static final String ROOM_TYPE_MEETING = "meeting";
    public static final String ROOM_TYPE_CONFERENCE = "conference";
    public static final String ROOM_TYPE_PHONE_BOOTH = "phone_booth";

    private final int roomNumber;
    private final String type;
    private Set<String> amenities;

    public Room(int roomNumber, String type, Set<String> amenities) {
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
