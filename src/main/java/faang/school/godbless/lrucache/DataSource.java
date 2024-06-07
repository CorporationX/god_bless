package faang.school.godbless.lrucache;

import java.util.HashMap;
import java.util.Map;

public class DataSource<V extends WithId> {

    private final Map<Integer, V> dataSource = new HashMap();

    public V put(V newData) {
        Integer id = dataSource.size() + 1;
        newData.setId(id);
        dataSource.put(id, newData);
        return newData;
    }

    public V get(Integer id) {
        return dataSource.get(id);
    }

    public int size() {
        return dataSource.size();
    }
}
