package faang.school.godbless.transportTracking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public final class Location {
    private final double latitude;
    private final double longitude;
}
