package faang.school.godbless.lrucashe;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DataService {
    private static final int CACHE_SIZE = 5;
    private final Map<Integer, Data> dataMap = new HashMap<>(CACHE_SIZE);

    public void addData(Data data) {
        if (dataMap.size() >= CACHE_SIZE) {
            removeOldObject();
        }
        data.setTimestamp(LocalDateTime.now());
        dataMap.put(data.getId(), data);
    }

    public Data getDataById(int id) {
        Data data = Optional.ofNullable(dataMap.get(id))
                .orElseThrow(() -> new IllegalArgumentException("Invalid id"));
        data.setTimestamp(LocalDateTime.now());
        return data;
    }

    private void removeOldObject() {
        dataMap.entrySet().stream()
                .min(Comparator.comparing(dataEntry -> dataEntry.getValue().getTimestamp()))
                .ifPresent(dataEntry -> dataMap.remove(dataEntry.getKey()));
    }

    public void showData() {
        dataMap.values().forEach(System.out::println);
    }
}
