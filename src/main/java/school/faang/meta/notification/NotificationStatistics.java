package school.faang.meta.notification;

import lombok.extern.slf4j.Slf4j;

import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class NotificationStatistics {
    private final Map<NotificationType, AtomicInteger> statistics = new EnumMap<>(NotificationType.class);
    private final AtomicInteger totalBlocked = new AtomicInteger();

    public NotificationStatistics() {
        for (NotificationType type : NotificationType.values()) {
            this.statistics.put(type, new AtomicInteger());
        }
    }

    public void increment(NotificationType type) {
        this.statistics.computeIfAbsent(type, k -> new AtomicInteger()).incrementAndGet();
    }

    public void addBlocked(int count) {
        this.totalBlocked.addAndGet(count);
    }

    public void printStatistics() {
        log.info("---> Notification Statistics <---");
        log.info("Total processed: {}", getTotalProcessed());
        log.info("Total successfully sent: {}", getSuccessfullySent());
        log.info("Total blocked: {}", this.totalBlocked.get());

        log.info("By type:");
        this.statistics.forEach((type, count) ->
                log.info(" -{}: {}", type, count.get()));
    }

    private int getTotalProcessed() {
        return getSuccessfullySent() + this.totalBlocked.get();
    }

    private int getSuccessfullySent() {
        return this.statistics.values().stream().mapToInt(AtomicInteger::get).sum();
    }
}
