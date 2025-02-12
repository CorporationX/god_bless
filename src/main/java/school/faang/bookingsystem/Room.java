package school.faang.bookingsystem;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Room {
    private static final Set<Integer> ROOMS = new HashSet<>();

    private int roomNumber;
    private String type;
    private Set<String> amenities;

    public Room(int roomNumber, String type, Set<String> amenities) {
        if (ROOMS.contains(roomNumber)) {
            throw new IllegalArgumentException("Room number already exists");
        }
        ROOMS.add(roomNumber);
        this.roomNumber = roomNumber;
        this.type = type;
        this.amenities = amenities;
    }
}
