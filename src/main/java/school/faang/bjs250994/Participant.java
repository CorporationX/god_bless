package school.faang.bjs250994;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Participant implements Runnable {

    private final Conference conference;

    public Participant(Conference conference) {
        if (conference == null) {
            log.error("Conference cannot be null");
            throw new IllegalArgumentException("Conference cannot be null");
        }
        this.conference = conference;
        log.info("Participant created ");
    }

    @Override
    public void run() {
        try {
            conference.joinConference();
            log.info("{} connected and joined the conference", Thread.currentThread().getName());
        } catch (Exception e) {
            log.error("Error while {} was attempting to join the conference", Thread.currentThread().getName(), e);
        }
    }
}