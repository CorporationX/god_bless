package school.faang.wow.model;

import school.faang.wow.Const;

import java.util.function.Supplier;

public record Quest(String name, int difficulty, int reward) implements Supplier<Integer> {
    @Override
    public Integer get() {
        try {
            Thread.sleep(difficulty * Const.DIFFICULTY_FACTOR);
            return reward;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
