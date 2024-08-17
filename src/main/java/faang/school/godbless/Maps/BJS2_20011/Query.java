package faang.school.godbless.Maps.BJS2_20011;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@Getter
public class Query {

    private final int id;
    private final String content;
    private final LocalDateTime timestamp;

    public Query(String content) {
        this.content = content;
        id = ThreadLocalRandom.current().nextInt(1, 1000);
        timestamp = LocalDateTime.now();
    }
}
