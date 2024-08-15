package faang.school.godbless.lrucashe;

import lombok.Getter;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;

@Getter
public class DataService {
    private static final Integer CACHE_SIZE = 5;
    private final Map<Integer, Data> dataMap = new HashMap<>();
    private final Queue<Data> cacheQueue = new PriorityQueue<>(Comparator.comparing(Data::getTimestamp));

    public void addData(Data data) {
        if (dataMap.size() == CACHE_SIZE) {
            removeOldObject();
        }
        dataMap.put(data.getId(), data);
        cacheQueue.add(data);
    }

    public Data getDataById(int id) {
        return Optional.ofNullable(dataMap.get(id))
                .map(data -> {
                    data.setTimestamp(LocalDate.now());
                    cacheQueue.remove(data);
                    cacheQueue.add(data);
                    return data;
                })
                .orElseGet(() -> {
                    Data newData = new Data(id, "value" + id, LocalDate.now());
                    addData(newData);
                    return newData;
                });
    }

    private void removeOldObject() {
        var oldestData = cacheQueue.poll();
        if (oldestData != null) {
            dataMap.remove(oldestData.getId());
        }
    }

    public void showData() {
        dataMap.values().forEach(System.out::println);
    }
}
