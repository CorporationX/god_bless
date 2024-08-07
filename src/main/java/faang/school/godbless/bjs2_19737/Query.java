package faang.school.godbless.bjs2_19737;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@EqualsAndHashCode
public class Query {
    private Integer id;
    private String content;
    @Getter
    private LocalDateTime timestamp;

    public Query(Integer id, String content) {
        this.id = id;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }
}
