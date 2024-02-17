package faang.school.godbless.googlemaps;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location {

    private String name;
    private double latitude;
    private double longitude;
}
