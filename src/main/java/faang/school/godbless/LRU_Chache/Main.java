package faang.school.godbless.LRU_Chache;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Integer,Data> dataMap = new HashMap<>();
    public static final int CACHE_SIZE = 10;
    public static void addData(Data data) {
        dataMap.put(data.getId(),data);
    }
    public static void getData(Data data) {

    }
}
