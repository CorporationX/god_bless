package school.faang.mice_nice;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Food {
    PIZZA(0),
    EGGS(1),
    BREAD(2),
    FRUIT(3),
    CHEESE(4),
    MEAT(5),
    MILK(6),
    VEGETABLES(7);

    private final int foodId;

    public static Food getById(int id) {
        for (Food value : values()) {
            if (value.foodId == id) {
                return value;
            }
        }
        return PIZZA;
    }
}
