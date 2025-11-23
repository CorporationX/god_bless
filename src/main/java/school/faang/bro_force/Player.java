package school.faang.bro_force;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Проект: god_bless
 * Класс Player
 * Автор: Vital
 */

@Getter
@AllArgsConstructor
public class Player {
    private final String name;

    //Генерация события очков
    public boolean earnedPoints() {
        return Math.random() < 0.5; // 50% шанс
    }

    //Генерация события потери жизни
    public boolean lostLife() {
        return Math.random() < 0.3; // 30% шанс
    }
}