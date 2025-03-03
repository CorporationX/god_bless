package school.faang;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class Participant {
    private final Conference conference;

    public void joinConference() {
        conference.join();
    }
}
