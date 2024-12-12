package school.faang.task47220;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Department {
    SALES_DEPARTMENT("Отдел продаж"),
    IT_DEPARTMENT("IT-отдел");

    private final String name;
}
