package faang.school.godbless.lru;

import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ServiceCache {
    private static final int CACHE_SIZE = 5;
    private final Map<Integer, Data> DBAllRequest = new HashMap<>();
    private final Map<Integer, Data> cacheRequest;

    public ServiceCache(Map<Integer, Data> cacheRequest) {
        if (cacheRequest == null || cacheRequest.isEmpty()) {
            throw new IllegalArgumentException("Trying to create ServiceCache with empty Map");
        }
        this.cacheRequest = cacheRequest;
        DBAllRequest.putAll(cacheRequest);
        while (cacheRequest.size() > CACHE_SIZE) {
            removeLastRequest();
        }
    }

    public void addNewData(Data data) {
        if (data == null) {
            throw new IllegalArgumentException(
                    "Attempt to create an empty request, in method addNewData class ServiceCache");
        }
        searchOrAddRequest(data);
    }

    public Data searchData(int ID) {
        if(!cacheRequest.containsKey(ID)) {
            if(!DBAllRequest.containsKey(ID)) {
                throw new RuntimeException("The query cannot be found in the database");
            }
            searchOrAddRequest(DBAllRequest.get(ID));
            return DBAllRequest.get(ID);
        }
        updateTime(cacheRequest.get(ID));
        return cacheRequest.get(ID);
    }

    public void printAllCache() {
        cacheRequest.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    private int searchOrAddRequest(Data data) {
        if (cacheRequest.containsKey(data.getID())) {
            updateTime(data);
        } else {
            while (cacheRequest.size() >= CACHE_SIZE) {
                removeLastRequest();
            }
            updateTime(data);
            cacheRequest.put(data.getID(), data);
        }
        return data.getID();
    }

    private void removeLastRequest() {
        cacheRequest.remove(cacheRequest
                .values()
                .stream()
                .min(Comparator.comparing(data -> data.getTimestamp()))
                .get()
                .getID()
        );
    }

    private void updateTime(Data request) {
        Date date = new Date();
        request.setTimestamp(date.getTime());
    }
}