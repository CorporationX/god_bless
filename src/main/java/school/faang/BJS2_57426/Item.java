package school.faang.BJS2_57426;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Item {

    private final String name;
    private int value;

    public Item(@NonNull String name, int value) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (value < 1) {
            throw new IllegalArgumentException("Цена не может быть отрицательной или равна 0");
        }

        this.name = name;
        this.value = value;
    }
}
