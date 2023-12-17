package faang.school.godbless.lru.cache;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        DataStructure ds = new DataStructure();
        Map<Integer, Data> dataStructure = new HashMap<>();

        for (int i = 0; i < 8; i++) {
            Data data = new Data(i, "data-" + i);
            ds.addData(data);
        }

        ds.getCacheCurrentState();
    }
}
