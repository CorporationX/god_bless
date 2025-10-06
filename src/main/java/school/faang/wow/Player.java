package school.faang.wow;

import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Проект: god_bless
 * Класс Player
 * Автор: Vital
 */

@Data
@AllArgsConstructor
public class Player {
    private static final Logger log = LoggerFactory.getLogger(Player.class);

    private static final int LEVEL_UP_THRESHOLD = 1000; //XP для повышения уровня

    @NonNull
    private String name;
    private int level;
    private int experience;

    public void addExperience(int exp) {
        if (exp <= 0) {
            log.warn("Попытка добавить неположительный опыт: {}", exp);
            return;
        }
        this.experience += exp;
        log.info("{} получил {} очков опыта. Всего опыта: {}", name, exp, experience);
    }

    public void tryLevelUp() {
        if (this.experience >= LEVEL_UP_THRESHOLD) {
            int levelsGained = this.experience / LEVEL_UP_THRESHOLD;
            this.level += levelsGained;
            this.experience = this.experience % LEVEL_UP_THRESHOLD;
            log.info("{} достиг нового уровня! Текущий уровень: {}, оставшийся опыт: {}", name, level, experience);
        }
    }
}