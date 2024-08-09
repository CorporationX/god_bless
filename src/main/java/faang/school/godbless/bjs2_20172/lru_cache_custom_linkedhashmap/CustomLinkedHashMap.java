package faang.school.godbless.bjs2_20172.lru_cache_custom_linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;

public class CustomLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    private final int maxSize;

    public CustomLinkedHashMap(int maxSize) {
        super(maxSize, 1);
        this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxSize;
    }
}
