package faang.school.godbless.lru;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final int CACHE_SIZE = 3;
    private static final Map<Integer, Data> STORAGE_HASH = new HashMap<>(CACHE_SIZE);

    public static void main(String[] args) {
        Data data1 = new Data(1, "something1", LocalDateTime.of(2024, 4, 1, 12, 1));
        Data data2 = new Data(2, "something2", LocalDateTime.of(2024, 4, 2, 12, 30));
        Data data3 = new Data(3, "something3", LocalDateTime.of(2024, 3, 3, 12, 45));
        Data data4 = new Data(4, "something4", LocalDateTime.of(2024, 4, 4, 12, 59));
        addData(data1);
        addData(data2);
        addData(data3);
        addData(data4);

        printAllCash();
        System.out.println();

        System.out.println(findDataById(2));
        System.out.println();

        System.out.println(findDataById(99));
    }

    private static void addData(Data data) {
        if (STORAGE_HASH.size() == CACHE_SIZE) {
            removeOldObject();
        }
        STORAGE_HASH.put(data.getId(), data);
    }

    private static Data findDataById(int id) {
        Data data = STORAGE_HASH.computeIfPresent(id, (key, value) -> {
            value.setTimestamp(LocalDateTime.now());
            return value;
        });
        if (data == null) {
            removeOldObject();
            data = STORAGE_HASH.computeIfAbsent(id, (value) -> getFromMockStructure(id));
        }
        return data;
    }

    private static void removeOldObject() {
        int oldDataId = STORAGE_HASH.entrySet().stream()
                .min(Comparator.comparing(entry -> entry.getValue().getTimestamp()))
                .orElseThrow(()->new NullPointerException("failed to delete an element in the hash")).getKey();

        STORAGE_HASH.remove(oldDataId);
    }

    private static Data getFromMockStructure(int id) {
        return new Data(id, "Data from mock", LocalDateTime.now());
    }

    private static void printAllCash() {
        STORAGE_HASH.forEach((id, data) -> System.out.println(data));
    }
}
