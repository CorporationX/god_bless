package school.faang.task_62130;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderStatus {
    NEW("Новый"),
    PROCESSED("Обработан");

    private final String status;
}
