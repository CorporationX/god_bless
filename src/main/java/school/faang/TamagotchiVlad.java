package school.faang;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequiredArgsConstructor
public class TamagotchiVlad {
    private static final Logger logger = LoggerFactory.getLogger(TamagotchiVlad.class);
    private final String name;
    private String state = "neutral";

    public synchronized void feed() {
        state = "well-fed";
        printVladInfo("eating");
    }

    public synchronized void play() {
        state = "cheerful";
        printVladInfo("playing");
    }

    public synchronized void clean() {
        state = "pure";
        printVladInfo("cleaning");
    }

    public synchronized void sleep() {
        state = "sleeping";
        printVladInfo("sleeping");
    }

    private void printVladInfo(String info) {
        logger.info("{} is {}. His condition is {}.", name, info, state);
    }
}
