package faang.school.godbless.sprint2.zoom;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Evgenii Malkov
 */
@RequiredArgsConstructor
@Slf4j
public class Participant {
    private final Conference conference;

    public void joinConference(int i) {
        log.info("{} участник присоединился к конференции", i);
        conference.getLatch().countDown();
    }
}
