package school.faang.minizoom;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Participant {
    private String name;
    private Conference conference;

    public void joinConference() {
        log.info(name + " присоединился к конференции.");
        conference.join();
    }
}
