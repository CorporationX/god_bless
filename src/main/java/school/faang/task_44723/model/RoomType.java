package school.faang.task_44723.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public enum RoomType {
    CONFERENCE("Conference"),
    MEETING("Meeting");

    private final String name;
}
