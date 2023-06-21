package faang.school.godbless.googleMaps;

import lombok.Data;
import lombok.NonNull;

@Data
public class Location {
    @NonNull
    private String name;
    @NonNull
    private Double latitude;
    @NonNull
    private Double longitude;

}
