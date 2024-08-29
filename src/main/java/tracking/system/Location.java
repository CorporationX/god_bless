package tracking.system;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public final class Location {
    private final double latitude;
    private final double longitude;
}