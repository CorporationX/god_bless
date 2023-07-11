package faang.school.godbless.finger_path;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class Location {

    private int latitude;
    private int longitude;

    public static Map<String, Location> locations = new HashMap<>();
}
