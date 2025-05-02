package school.faang.bjs2_74804;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class Store {
    public static Item getItem() {
        return new Item("Sword", 1000);
    }
}
