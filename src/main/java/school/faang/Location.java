package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Location {
    private String name;
    private double latitude;
    private double longitude;
}
