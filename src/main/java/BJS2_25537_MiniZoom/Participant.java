package BJS2_25537_MiniZoom;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class Participant {
    private final String nickName;

    public void joinConference(Conference conference) {
        log.info("Connected to conference: {}", nickName);
        conference.awaitAllToJoin();
    }
}
