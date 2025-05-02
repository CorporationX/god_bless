package school.faang.concurrency.tracking_system;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
public final class Location {

    private final double latitude;
    private final double longitude;
}
