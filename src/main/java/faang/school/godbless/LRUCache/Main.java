package faang.school.godbless.LRUCache;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final int CACHE_SIZE = 10;
    private static Map<Long, Data> map;


    private static void addData(Data data) {
        if (map == null){
            map = new HashMap<>();
        }
        if (map.size()>=CACHE_SIZE) {
            map.remove(map.entrySet().
                            stream().//преобразуем в поток
                            min(Comparator.comparing(o -> o.getValue().getTimestamp())).//ищем мин
                            get().//получаем Entry из Optional
                            getKey()// получаем ключ
            );
        }
        map.put(data.getId(), data);
    }
}
