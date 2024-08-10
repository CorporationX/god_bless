package faang.school.godbless.task.lru.cache;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
public class DataStructure {
    private final Map<Integer, Data> dataBase;

    public void addData(@NonNull Data data) {
        if (dataBase.containsKey(data.getId())) {
            throw new IllegalArgumentException("Данные %s уже есть".formatted(data));
        }
        dataBase.put(data.getId(), data);
    }

    public Data findDataById(int id) {
        if (!dataBase.containsKey(id)) {
            throw new NoSuchElementException("Данные с id: %s не найдены".formatted(id));
        }
        return dataBase.get(id);
    }
}
