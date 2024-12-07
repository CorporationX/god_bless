package school.faang.task_44723.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Getter
@ToString
@AllArgsConstructor
public class Room {
    private final int id;
    private final RoomType type;
    private final Set<Amenity> amenities;
}
