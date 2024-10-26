package school.faang.bjs2_39094;

import lombok.Getter;

public record Task(String name, Task.Difficulty difficulty, int reward) {

    @Getter
    public enum Difficulty {
        EASY(3_000), MEDIUM(5_000), HARD(6_000);

        private final int time;

        Difficulty(int time) {
            this.time = time;
        }
    }
}
