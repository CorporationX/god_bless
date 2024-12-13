package school.faang.sprint_1.task_lordofringsbjs2n45608;

import lombok.Getter;

@Getter
public class Item {
    private final String name;
    private final int value;

    public Item(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Item{"
                + "name='" + name + '\''
                + ", value=" + value
                + '}';
    }
}
