package faang.school;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
public final class Location {
    private final double latitude;
    private final double longitude;
}
