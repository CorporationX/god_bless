package faang.school.godbless.sprint4.multithreading_parallelism_thread.task10;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Monster {
    private String name;

    private int location;

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                '}';
    }
}
