package faang.school.godbless.BJS2_19821;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Random;

@ToString
public class Query {
    private static int queryIndex = 0;
    private int id;
    @Getter
    private String content;
    @Getter
    private LocalDateTime timestamp;

    private LocalDateTime generateTimestamp() {
        Random random = new Random();
        int hours = random.nextInt(20) - 10;
        int minutes = random.nextInt(20) - 10;
        int seconds = random.nextInt(20) - 10;
        return LocalDateTime.now().plusHours(hours).plusMinutes(minutes).plusSeconds(seconds);
    }

    public Query(String content) {
        this.id = ++queryIndex;
        this.content = content;
        this.timestamp = generateTimestamp();
    }
}
