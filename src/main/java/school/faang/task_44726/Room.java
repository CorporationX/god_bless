package school.faang.task_44726;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;
@ToString
@Builder
@Getter
public class Room {
    private int roomId;
    private String type;
    private Set<String> amenities;
}
