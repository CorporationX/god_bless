package faang.school.godbless.mini_zoom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@AllArgsConstructor
public class Participant {
    private String name;

    public void joinConference() {
        log.info("Participant with name - {}, waiting!", name);
    }
}
