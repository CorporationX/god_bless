package faang.school.godbless.BJS2_3191;

import lombok.Data;
import lombok.NonNull;

@Data
public class City {
    @NonNull
    private String name;
    @NonNull
    private Location location;
    @NonNull
    private Integer witcherDistance;
}
