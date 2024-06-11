package faang.school.godbless.LRUCache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Integer, Data> dataObjects = new HashMap<>();
    private static List<Data> dataList = new LinkedList<>();
    private static final int CACHE_SIZE = 10;
    public static void main(String[] args) {


    }
    static void addData(Data data){
        if (dataObjects.keySet().size() < CACHE_SIZE){
            dataObjects.put(data.getId(), data);
        }
        throw new IllegalArgumentException("Превышен лимит ключей");
    }
}
