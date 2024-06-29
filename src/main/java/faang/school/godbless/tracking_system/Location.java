package faang.school.godbless.tracking_system;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public final class Location {
    private final double latitude;
    private final double longitude;
}
