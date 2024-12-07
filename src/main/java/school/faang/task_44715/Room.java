package school.faang.task_44715;

import lombok.Getter;

import java.util.Set;

@Getter
public class Room {
    private int roomId;
    private String type;
    private Set<String> amenities;
}
