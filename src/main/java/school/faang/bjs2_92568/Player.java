package school.faang.bjs2_92568;

import lombok.Getter;

@Getter
public class Player {
    private final String name;
    private int level;
    private int experience;

    public Player(String name, int level, int experience) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Ошибка: Имя персонажа не может быть пустым или null");
        }
        if (experience < 0 || experience > 100000) {
            throw new IllegalArgumentException("Ошибка: опыт персонажа не может быть меньше нуля или больше 100,000");
        }
        if (level < 0 || level > 1000) {
            throw new IllegalArgumentException(
                    "Ошибка: Уровень персонажа не может быть меньше нуля, макс уровень - 1000"
            );
        }
        this.name = name;
        this.level = level;
        this.experience = experience;
    }

    public synchronized void addExperience(int expCount) {
        this.experience += expCount;
    }

    public synchronized void addLevel(int value) {
        this.level += value;
    }
}