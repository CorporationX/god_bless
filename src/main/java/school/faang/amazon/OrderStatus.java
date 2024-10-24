package school.faang.amazon;

import lombok.Getter;

@Getter
public enum OrderStatus {
    DONE("Обработано"),
    NEW("Новый");

    private final String status;

    OrderStatus(String status) {
        this.status = status;
    }
}

