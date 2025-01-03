package school.faang.task_51001;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Participant implements Runnable {
    private final String name;
    private final Conference conference;

    @Override
    public void run() {
        log.info("{} joined the conference", name);
        conference.join();
    }
}
