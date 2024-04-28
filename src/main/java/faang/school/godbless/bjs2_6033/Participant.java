package faang.school.godbless.bjs2_6033;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Participant {

    private String name;

    public void joinConference(Conference conference) {
        log.info("{} want to join {} conference", name, conference.getName());
        conference.startStreaming();
    }
}
