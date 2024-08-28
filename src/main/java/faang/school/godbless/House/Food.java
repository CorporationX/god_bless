package faang.school.godbless.House;

import lombok.Getter;

@Getter
public class Food {
    private String name;

    public Food(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
