package faang.school.godbless.thirdsprint.thomasandjerry;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Food {
    private final String name;

    @Override
    public String toString() {
        return name;
    }
}
