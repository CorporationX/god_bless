package school.faang.bjs2_75806;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@Getter
public class Conference {
    private final String name;
    private final int requiredParticipants = 5;
    private volatile boolean isStarted = false;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private final Set<Participant> participants = new HashSet<>();

    public Conference(String name) {
        this.name = name;
    }

    public void startStreaming() {
        log.info("Conference {} started", name);
        isStarted = true;
    }

    public void addParticipant(Participant participant) {
        lock.lock();
        try {
            if (isStarted) {
                throw new ConferenceAlreadyStarted();
            }
            log.info("Participant {} joined conference {}", participant.name(), name);
            participants.add(participant);
            while (participants.size() < requiredParticipants && !isStarted) {
                condition.await();
            }

            if (!isStarted && participants.size() >= requiredParticipants) {
                startStreaming();
                condition.signalAll();
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            log.error("Thread stopped exception");
            throw new ThreadStoppedException(ex);
        } finally {
            lock.unlock();
        }
    }
}
