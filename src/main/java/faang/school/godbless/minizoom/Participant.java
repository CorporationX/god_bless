package faang.school.godbless.minizoom;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Participant {

    private final String name;

    public void joinConference(Conference conference) {
        log.info("{} want to join {} conference", name, conference.getName());
        conference.startStreaming();
    }
}
