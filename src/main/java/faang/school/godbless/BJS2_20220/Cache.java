package faang.school.godbless.BJS2_20220;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cache extends LinkedHashMap<Integer, DaTa> {
    private final int CACHE_SIZE;

    public Cache(int size) {
        super(size, 0.75f, true);
        this.CACHE_SIZE = size;
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, DaTa> eldest) {
        return size() > CACHE_SIZE;
    }
}
