package faang.school.godbless.java_hashmap.lru_cache;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Data {

    private int id;
    private String data;
    private LocalDateTime timestamp;
}
