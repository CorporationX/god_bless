package faang.school.godbless.lambda.task13google_maps;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location {
    private String name;
    private double latitude;
    private double longitude;
}
