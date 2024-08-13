package faang.school.godbless.task.lambda.google.maps;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class Location {
    private final String name;
    private final double latitude;
    private final double longitude;
}
