package school.faang.bjs2_68731;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {
    FOOD("Еда"),
    ELECTRONICS("Электроника"),
    CLOTHING("Одежда"),
    OTHER("Прочее");

    private final String description;
}
