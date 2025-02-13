package school.faang.task_60008;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor
public class Location {
    private final String name;
    private final double latitude;
    private final double longitude;
}
