package google.maps;

import lombok.Data;

@Data
public class Location {
    private final String name;
    private final double latitude;
    private final double longitude;
}
