package faang.school.godbless.javahashmap.lrucache;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Pair<K, V> {
    private K key;
    private V value;
}
