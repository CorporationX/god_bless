package school.faang.bjs2_80226;

import lombok.Getter;

enum CategoryEnum {
    FOOD("Еда"),
    ELECTRONICS("Электроника"),
    CLOTHING("Одежда"),
    OTHER("Другое");

    @Getter
    private final String displayName;

    CategoryEnum(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
