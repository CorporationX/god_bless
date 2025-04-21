package school.faang.exthreadpool;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Chore implements Runnable{
    private final String chore;

    public Chore(String chore) {
        this.chore = chore;
        log.info("Обязанность {} создана", this.getChore());
    }

    @Override
    public void run() {
        log.info("Обязанность {} выполняется", this.getChore());
    }
}
