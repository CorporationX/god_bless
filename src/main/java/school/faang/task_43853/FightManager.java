package school.faang.task_43853;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
public class FightManager {

    public void fight(Character character1, Character character2) {
        do {
            character1.attack(character2);
            if (!character2.isAlive()) {
                break;
            }
            character2.attack(character1);
            if (!character1.isAlive()) {
                break;
            }
        } while (true);

        log.info("The winner is {}", character1.isAlive() ? character1.getName() : character2.getName());
    }
}
