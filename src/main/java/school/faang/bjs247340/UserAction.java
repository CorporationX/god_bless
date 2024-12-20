package school.faang.bjs247340;

import lombok.extern.slf4j.Slf4j;
import java.time.LocalDate;

@Slf4j
public record UserAction(int id, String name, String actionType, LocalDate actionDate, String content) {

    public UserAction {
        log.info("Creating UserAction record with id = {}, name = {}", id, name);
    }
}
