package faang.school.godbless.lru.сache;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@lombok.Data
@AllArgsConstructor
public class Data {

    private int id;
    private String value;
    private LocalDateTime timestamp;

}
