package school.faang.task_50209;

import lombok.Getter;

@Getter
public enum OrderStatus {
    NEW("Новый"),
    PROCESSED("Обработано");

    private final String status;

    OrderStatus(String status) {
        this.status = status;
    }

}
