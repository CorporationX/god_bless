package faang.school.godbless.task.lambda.handling.exceptions.beautifully;

import java.util.Map;
import java.util.NoSuchElementException;

public class SomeData {
    private Map<Integer, String> dataBase;

    public SomeData() {
        this.dataBase = Map.of(1, "A", 2, "B", 3, "C");
    }

    public String getData(Integer id) {
        if (!dataBase.containsKey(id)) {
            throw new NoSuchElementException("Ошибка, данных с id: %d не обнаружено.".formatted(id));
        }
        return dataBase.get(id);
    }
}
