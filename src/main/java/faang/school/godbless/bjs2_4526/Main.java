package faang.school.godbless.bjs2_4526;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {

    private static final int CACHE_SIZE = 3;
    private static final Map<Integer, Data> DATA_MAP = new HashMap<>(CACHE_SIZE);

    public static void main(String[] args) {
        Data data1 = new Data(1, "Val1", LocalDateTime.of(2024, 4, 5, 11, 30));
        Data data2 = new Data(2, "Val2", LocalDateTime.of(2024, 4, 5, 11, 35));
        Data data3 = new Data(3, "Val3", LocalDateTime.of(2024, 4, 5, 11, 40));
        Data data4 = new Data(4, "Val4", LocalDateTime.of(2024, 4, 5, 12, 50));
        addData(data4);
        addData(data2);
        addData(data1);
        addData(data3);

        printCache();

        System.out.println("\nПоиск данных с ID: 2");
        System.out.println(findDataById(2));

        System.out.println("\nПоиск данных которых нет в кэше с ID: 99");
        System.out.println(findDataById(99));

    }

    public static void addData(Data data) {
        if (DATA_MAP.size() == CACHE_SIZE) {
            removeOldObject();
        }
        DATA_MAP.put(data.getId(), data);
    }

    public static Data findDataById(Integer dataId) {
        Data data = DATA_MAP.computeIfPresent(dataId, (key, value) -> {
            value.setTimestamp(LocalDateTime.now());
            return value;
        });
        if (data == null) {
            data = DATA_MAP.computeIfAbsent(dataId, key -> mockDataStructure(dataId));
        }
        return data;
    }

    private static void removeOldObject() {
        Integer oldDataId = Objects.requireNonNull(DATA_MAP.entrySet()
                .stream()
                .min(Comparator.comparing(d -> d.getValue().getTimestamp()))
                .orElse(null)).getKey();
        DATA_MAP.remove(oldDataId);
    }

    public static void printCache() {
        for (Map.Entry<Integer, Data> entry : DATA_MAP.entrySet()) {
            System.out.println(entry.getValue());
        }
    }


    public static Data mockDataStructure(Integer dataId) {
        return new Data(dataId, "Mock value", LocalDateTime.now());
    }
}
