package faang.school.godbless.lruCache;

import lombok.*;

import java.time.LocalDateTime;

@lombok.Data
@Builder
@AllArgsConstructor
public class Data {

    private Integer id;
    private String value;
    private LocalDateTime timestamp;
}
