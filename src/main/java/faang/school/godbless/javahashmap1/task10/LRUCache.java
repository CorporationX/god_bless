package faang.school.godbless.javahashmap1.task10;

import java.util.Map;
import java.util.LinkedHashMap;

@lombok.Data
public class LRUCache {
    private static final int CACHE_SIZE = 4;
    private Map<Integer, Node> cache;

    public LRUCache() {
        cache = new LinkedHashMap<>(CACHE_SIZE, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Node> eldest) {
                return size() > CACHE_SIZE;
            }
        };
    }

    public Data get(int key) {
        Node node = cache.get(key);
        return (node != null) ? node.getData() : null;
    }

    public void add(Data data) {
        Node node = new Node(data);
        cache.put(data.getId(), node);
    }
}



