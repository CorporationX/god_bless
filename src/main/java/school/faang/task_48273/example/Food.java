package school.faang.task_48273.example;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Food {
    private final String name;

    @Override
    public String toString() {
        return name;
    }
}
