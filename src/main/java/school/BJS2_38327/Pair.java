package school.BJS2_38327;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Pair<K, V> {
    private K key;
    private V value;

}