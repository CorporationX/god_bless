package faang.school.godbless.MiniZoom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
public class Participant {
    private String userName;

    public void joinConference(Conference conference) {
        log.info("participant {} trying to join conference - {}", userName, conference.getTitle());
        conference.join(this);
    }
}
