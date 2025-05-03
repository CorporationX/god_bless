package school.faang.bjs2_75806;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class ParticipantService {
    private final Participant participant;

    public void joinConference(Conference conference) {
        try {
            conference.addParticipant(participant);
        } catch (ConferenceAlreadyStarted ex) {
            log.warn("Participant {} cannot join conference {}, conference already started",
                    participant.name(), conference.getName());
        }
    }
}
