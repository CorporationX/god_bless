package school.faang.bjs2_92568;

import lombok.Getter;

@Getter
public class Quest {
    private final String name;
    private final int difficulty;
    private final int reward;

    public Quest(String name, int difficulty, int reward) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Ошибка: Имя персонажа не может быть пустым или null");
        }
        if (difficulty < 0 || difficulty > 10) {
            throw new IllegalArgumentException("Ошибка: не может быть меньше нуля, макс уровень сложности - 10");
        }
        if (reward < 0 || reward > 1000) {
            throw new IllegalArgumentException(
                    "Ошибка: Награда за задание не может быть меньше нуля, макс значение - 1000"
            );
        }
        this.name = name;
        this.difficulty = difficulty;
        this.reward = reward;
    }
}