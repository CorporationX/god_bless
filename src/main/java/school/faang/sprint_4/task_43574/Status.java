package school.faang.sprint_4.task_43574;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Status {
    NEW("Новый"),
    PROCESSED("Обработан"),
    CANCELLED("Отменен");

    private final String status;
}