package faang.school.godbless.Maps.BJS2_20420;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.security.PrivateKey;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
@ToString
public class Data {
    private final int id;
    private String value;
    private LocalDateTime timestamp;

    public Data(String value) {
        this.value = value;
        this.id = ThreadLocalRandom.current().nextInt(1, 10000);
    }

    public void updateTimestamp(){
        timestamp = LocalDateTime.now();
    }
}
