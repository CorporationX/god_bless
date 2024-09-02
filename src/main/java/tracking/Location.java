package tracking;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public final class Location {
    private final double latitude;
    private final double longitude;
}
