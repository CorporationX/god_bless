package school.faang.parse_the_warehouse_amazon;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Category {
    FOOD("Продукты питания"),
    ELECTRONICS("Электроника"),
    CLOTHING("Одежда"),
    BOOKS("Книги"),
    FURNITURE("Мебель"),
    OTHER("Другое");

    private final String displayName;

}
