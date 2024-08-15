package faang.school.godbless.RPG;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class Item {
    private String name;
    private int value;
    private boolean isRemovable;
    private boolean isPerishable;

    public Item(String name, int value, boolean isRemovable) {
        this.name = name;
        this.value = value;
        this.isRemovable = true;
        this.isPerishable = false;
    }

    @Override
    public String toString() {
        return this.name + " - " + this.value + " gold";
    }
}
