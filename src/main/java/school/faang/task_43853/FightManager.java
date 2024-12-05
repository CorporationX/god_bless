package school.faang.task_43853;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.InputMismatchException;

@Slf4j
@NoArgsConstructor
public class FightManager {
    private static FightManager INSTANCE;

    public void fight(Character character1, Character character2) {
        do {
            try {
                character1.attack(character2);
                if (!character2.isAlive()) {
                    break;
                }
                character2.attack(character1);
                if (!character1.isAlive()) {
                    break;
                }
            } catch (InputMismatchException ex) {
                log.error("Mistake: The fight lasts too long");
                break;
            }
        } while (true);

        log.info("The winner is {}", character1.isAlive() ? character1.getName() : character2.getName());
    }

    public static FightManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FightManager();
        }
        return INSTANCE;
    }
}
