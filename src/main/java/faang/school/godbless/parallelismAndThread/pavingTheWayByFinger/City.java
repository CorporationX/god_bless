package faang.school.godbless.parallelismAndThread.pavingTheWayByFinger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class City {
    private String name;
    private Map<String, Integer> distances;
}
