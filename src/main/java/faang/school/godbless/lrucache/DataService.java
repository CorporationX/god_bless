package faang.school.godbless.lrucache;

import java.util.HashMap;
import java.util.Map;

public class DataService {
    private static Map<Integer, Data> dataStructure = new HashMap<>();

    public static Data getDataById(int id) {
        return dataStructure.get(id);
    }

    public static void addData(Data data) {
        dataStructure.put(data.getId(), data);
    }
}
