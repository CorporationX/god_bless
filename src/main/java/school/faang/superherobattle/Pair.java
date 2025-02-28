package school.faang.superherobattle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Data
public class Pair<K, V> {
    private final K key;
    private final V value;
}
