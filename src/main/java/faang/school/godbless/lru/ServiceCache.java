package faang.school.godbless.lru;

import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ServiceCache {
    private static final int CACHE_SIZE = 5;
    private final Map<Integer, Data> cacheRequest;
    private int sizeCache = 0;

    public ServiceCache(Map<Integer, Data> cacheRequest) {
        if (cacheRequest == null) {
            throw new IllegalArgumentException("Trying to create ServiceCache with empty Map");
        }
        this.cacheRequest = cacheRequest;
        sizeCache = cacheRequest.size();
    }

    public void addNewData(Data data) {
        if (data == null) {
            throw new IllegalArgumentException("attempt to create an empty request");
        }
        while(sizeCache < CACHE_SIZE) {
            removeLastRequest();
        }
        searchRequest(data);
        sizeCache++;
    }

    public Data searchData(Data data) {
        if (data == null) {
            throw new IllegalArgumentException("attempt to create an empty request");
        }
        return cacheRequest.get(searchRequest(data));
    }

    public void printAllCache() {
        cacheRequest.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    private void removeLastRequest() {
        cacheRequest.entrySet()
                .stream()
                .min()
    }

    private int searchRequest(Data data) {
        Date date = new Date();

    }

}
