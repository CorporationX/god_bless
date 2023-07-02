package faang.school.godbless.google_maps;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class Location {
    private String name;
    private double latitude;
    private double longitude;
}
