package school.faang.task_48704;

import lombok.Getter;

@Getter
public class Food {
    private final String name;
    private final int quantity;

    public Food(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Food{" + "name='" + name + '\'' + ", quantity=" + quantity + '}';
    }
}
