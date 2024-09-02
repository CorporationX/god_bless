package faang.school.godbless.task.multithreading.concurrency.mini.zoom;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Participant(long id) {
    public void joinConference(Conference conference) {
        log.info("Participant id: {} trying connect to conference id: {}", id, conference.getId());
        conference.join(this);
    }
}
