package school.faang.wow.model;

import lombok.extern.slf4j.Slf4j;
import school.faang.wow.Const;

import java.util.function.Supplier;

@Slf4j
public record Quest(String name, int difficulty, int reward) implements Supplier<Integer> {
    @Override
    public Integer get() {
        try {
            Thread.sleep(difficulty * Const.DIFFICULTY_FACTOR);
            return reward;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }
}
