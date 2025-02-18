package school.faang.maps;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location {
    private final String name;
    private final double latitude;
    private final double longitude;
}
