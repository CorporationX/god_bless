package school.faang.sprint2.bjs2_57543;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Item {
    private String name;
    private int value;

    public Item(@NonNull String name, int value) {
        if (name.isBlank()) {
            log.error("Попытка ввести пустое имя предмета: {}", name);
            throw new IllegalArgumentException("Название предмета не может быть пустым");
        }
        if (value < 0 || value > 200000) {
            log.error("Попытка ввести стоимость, выходящую за допустимые рамки");
            throw new IllegalArgumentException("Стоимость предмета не должна выходить за диапазон: 0 - 200.000");
        }
        this.name = name;
        this.value = value;
    }
}
