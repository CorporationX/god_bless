package school.faang;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class TamagotchiVlad {
    private final String name;
    private TamagotchiState state = TamagotchiState.NEUTRAL;

    public synchronized void feed() {
        state = TamagotchiState.WELL_FED;
        printVladInfo("eating");
    }

    public synchronized void play() {
        state = TamagotchiState.CHEERFUL;
        printVladInfo("playing");
    }

    public synchronized void clean() {
        state = TamagotchiState.PURE;
        printVladInfo("cleaning");
    }

    public synchronized void sleep() {
        state = TamagotchiState.SLEEPING;
        printVladInfo("sleeping");
    }

    private void printVladInfo(String info) {
        log.info("{} is {}. His condition is {}.", name, info, state.name());
    }
}
