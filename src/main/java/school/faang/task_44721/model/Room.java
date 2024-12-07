package school.faang.task_44721.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import school.faang.task_44721.enums.Amenities;
import school.faang.task_44721.enums.RoomType;

import java.util.Set;

@Data
@AllArgsConstructor
public class Room {
    private int id;
    private RoomType type;
    private Set<Amenities> amenities;
    private boolean isAvailable;
}
