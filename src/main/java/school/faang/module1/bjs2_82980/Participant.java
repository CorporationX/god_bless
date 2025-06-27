package school.faang.module1.bjs2_82980;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Participant implements Runnable{

    private final String name;
    private final Conference conference;

    @Override
    public void run() {
        log.info("{} подключается к конференции", name);
        conference.awaitParticipant();
        log.info("{} готов к трансляции", name);
    }
}