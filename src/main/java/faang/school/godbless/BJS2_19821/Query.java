package faang.school.godbless.BJS2_19821;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Random;


@EqualsAndHashCode
@ToString
public class Query implements Comparable<Query> {
    private final Long id;
    private final String content;
    @Getter
    private final LocalDateTime timestamp;

    private LocalDateTime generateTimestamp() {
        Random random = new Random();
        int hours = random.nextInt(20) - 10;
        int minutes = random.nextInt(20) - 10;
        int seconds = random.nextInt(20) - 10;
        return LocalDateTime.now().plusHours(hours).plusMinutes(minutes).plusSeconds(seconds);
    }

    public Query(Long id, String content) {
        this.id = id;
        this.content = content;
        this.timestamp = generateTimestamp();
    }

    @Override
    public int compareTo(Query query) {
        return -this.timestamp.compareTo(query.getTimestamp());
    }
}
