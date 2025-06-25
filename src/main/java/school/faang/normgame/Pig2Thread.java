package school.faang.normgame;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Danil Pudovkin
 * @since 22.06.2025
 */
@Slf4j(topic = "Pig1Thread")
public class Pig2Thread extends PigThread {

    public Pig2Thread() {
        super("Нуф-Нуф", "палки", 400);
    }

}
