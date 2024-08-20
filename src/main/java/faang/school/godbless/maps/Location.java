package faang.school.godbless.maps;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Location {
    private final String name;
    private final double latitude;
    private final double longitude;
}
