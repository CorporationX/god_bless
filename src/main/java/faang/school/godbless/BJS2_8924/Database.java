package faang.school.godbless.BJS2_8924;

import java.util.HashMap;
import java.util.Map;

public class Database {
    private final Map<Integer, String> storage = new HashMap<>();

    public void addDataToDatabase(Integer key, String value) {
        storage.put(key, value);
    }

    public String getDataFromDatabase(Integer key) {
        return storage.get(key);
    }

    public boolean contains(Integer key) {return storage.containsKey(key);}
}
