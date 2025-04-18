package school.faang.bjs2_68999;

import java.util.Set;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Room {
    private static int counter = 0;
    @EqualsAndHashCode.Include
    private final int roomNumber;
    private String type;
    private Set<String> amenities;

    public Room(String type, Set<String> amenities) {
        this.roomNumber = ++counter;
        this.type = type;
        this.amenities = amenities;
    }
}
