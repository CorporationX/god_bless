package lru.cache;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Data {
    private static int idCount = 1;
    private final int id;
    private final String value;
    private LocalDateTime timestamp;

    public Data(@NonNull String value, @NonNull LocalDateTime timestamp) {
        this.id = idCount++;
        this.value = value;
        this.timestamp = timestamp;
    }
}
