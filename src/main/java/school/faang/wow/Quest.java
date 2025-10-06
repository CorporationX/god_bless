package school.faang.wow;

import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Проект: god_bless
 * Класс Quest
 * Автор: Vital
 */

@Data
@AllArgsConstructor
public class Quest {
    private static final Logger log = LoggerFactory.getLogger(Quest.class);

    public static final int DEFAULT_DIFFICULTY = 5; // сек
    public static final int DEFAULT_REWARD = 50; // XP

    @NonNull
    private String name;
    private int difficulty;
    private int reward;

    public void start() {
        log.info("Квест \"{}\" начался. Сложность: {} сек., награда: {} XP", name, difficulty, reward);
    }
}