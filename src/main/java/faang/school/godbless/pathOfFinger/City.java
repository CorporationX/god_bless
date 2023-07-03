package faang.school.godbless.pathOfFinger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.Map;

@Getter
@AllArgsConstructor
public class City {
    @NonNull
    private String name;
    @NonNull
    private int location;
    @NonNull
    private Map<String, Integer> distances;
}
