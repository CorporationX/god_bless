package faang.school.godbless.javaHashMap.LRU_Cache;

import java.util.HashMap;
import java.util.Map;

public class DataService {
    private final Map<Integer, Data> dataStructure;

    public DataService() {
        dataStructure = new HashMap<>();

        addData(new Data(1, "int"));
        addData(new Data(2, "byte"));
        addData(new Data(3, "short"));
        addData(new Data(4, "long"));
        addData(new Data(5, "double"));
        addData(new Data(6, "float"));
        addData(new Data(7, "char"));
        addData(new Data(8, "boolean"));
        addData(new Data(9, "String"));
        addData(new Data(10, "List"));
        addData(new Data(11, "Map"));
        addData(new Data(12, "Object"));
    }

    public void addData(Data data) {
        dataStructure.put(data.getId(), data);
        data.updateTimestamp();
    }

    public Data getData(int id) {
        return dataStructure.get(id);
    }
}
