package school.faang.normgame;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Danil Pudovkin
 * @since 22.06.2025
 */
@Slf4j(topic = "Pig1Thread")
public class Pig1Thread extends PigThread {

    public Pig1Thread() {
        super("Ниф-Ниф", "солома", 200);
    }

}
