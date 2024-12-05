package school.faang.task_44723.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public enum Amenity {
    PROJECTOR("Projector"),
    VIDEO_CONFERENCE("Video conference");

    private final String name;
}
