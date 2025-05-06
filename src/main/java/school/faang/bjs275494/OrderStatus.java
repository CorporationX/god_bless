package school.faang.bjs275494;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {
    NEW("Новый"),
    PROCESSED("Обработано"),
    FAILED("Ошибка");

    private final String name;
}
