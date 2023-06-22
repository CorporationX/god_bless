package faang.school.godbless.sprint_3.google_maps;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Location {
    private String name;
    private double latitude;
    private double longitude;

}
