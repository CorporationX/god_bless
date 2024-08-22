package faang.school.godbless.BJS2_24222;

import lombok.AllArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
public class LocalDateTimeForRocket implements Comparable<LocalDateTimeForRocket> {
    private LocalDateTime dateTime;

    public long getWaitingTime() {
        long mills = toMills();
        return mills + (mills / 10L);
    }

    public long toMills() {
        return Duration.between(LocalDateTime.now(), dateTime).toMillis();
    }

    public static LocalDateTimeForRocket findDateTimeLatestRocketLaunch(List<RocketLaunch> rocketLaunches) {
        return rocketLaunches.stream()
                .map(RocketLaunch::getStartDateTime)
                .max(Comparator.naturalOrder())
                .orElse(new LocalDateTimeForRocket(LocalDateTime.now()));
    }

    @Override
    public int compareTo(LocalDateTimeForRocket o) {
        return dateTime.compareTo(o.dateTime);
    }

    @Override
    public String toString() {
        return dateTime.toString();
    }
}
