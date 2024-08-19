package faang.school.godbless.lru.services;

import faang.school.godbless.lru.models.Data;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

public class DataService {

    public static final int CACHE_SIZE = 3;

    public static void addNewDataToCache(Map<Integer, Data> cacheLRU, Data data) {
        if (data != null) {
            if (cacheLRU.size() < CACHE_SIZE) {
                cacheLRU.put(data.getId(), data);
            } else {
                Optional<Data> optionalData = cacheLRU.values().stream()
                        .min(Comparator.comparing(Data::getDate));
                if (optionalData.isPresent()) {
                    cacheLRU.remove(optionalData.get().getId());
                    cacheLRU.put(data.getId(), data);
                }
            }
        }
    }

    public static void getDataFromCacheById(Map<Integer, Data> cacheLRU, int id) {
        Data data = cacheLRU.get(id);

        if (data != null) {
            System.out.println(data);
            data.updateDateToNow();
        } else {
            data = new Data(id, "data from method getDataFromCacheById");
            addNewDataToCache(cacheLRU, data);
        }
    }

    public static void printCurrentCache(Map<Integer, Data> cacheLRU) {
        System.out.println("Cache:");
        cacheLRU.forEach((k, v) -> {
            System.out.println("Id " + k);
            System.out.println(v);
        });
    }
}
