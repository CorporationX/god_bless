package faang.school.godbless.lru;

import java.util.Date;
import java.util.Map;

public class ServiceCache {
    private static final int CACHE_SIZE = 5;
    private final Map<Integer, Data> cacheRequest;
    private int requestСounter = 0;
    private int counterID;

    public ServiceCache(Map<Integer, Data> cacheRequest) {
        if (cacheRequest == null) {
            throw new IllegalArgumentException("Trying to create ServiceCache with empty Map");
        }
        this.cacheRequest = cacheRequest;
        requestСounter = cacheRequest.size();
        counterID = cacheRequest.size();
    }

    public void addNewData(Data data) {
        if (data == null) {
            throw new IllegalArgumentException("attempt to create an empty request");
        }
        searchRequest(data);
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

    private int searchRequest(Data data) {
        Date date = new Date();
        if (cacheRequest.containsKey(data.getID())) {
            data.setTimestamp(date.getTime());
            requestСounter++;
        } else {
            if (requestСounter < CACHE_SIZE) {
                cacheRequest.put(data.getID(), data);
            } else {
                cacheRequest.remove(cacheRequest
                        .entrySet()
                        .stream()
                        .mapToLong(entry -> entry.getValue().getTimestamp())
                );
                data.setTimestamp(date.getTime());
                cacheRequest.put(counterID, data);
            }
            requestСounter++;
            while (counterID == data.getID())
                counterID++;
        }
        return data.getID();
    }
}
