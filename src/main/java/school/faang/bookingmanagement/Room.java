package school.faang.bookingmanagement;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

/*
 * Related to JIRA ticket: BJS2-68742
 * */
@RequiredArgsConstructor
@Setter
@Getter
public class Room {
    private final int roomNumber; // предпологаю,что roomNumber уникален
    private String type;
    private Set<String> amenities;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Room room = (Room) o;
        return roomNumber == room.roomNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber);
    }
}
