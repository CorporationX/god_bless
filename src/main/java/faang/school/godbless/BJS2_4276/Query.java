package faang.school.godbless.BJS2_4276;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@ToString
public class Query {

    private Long id;
    private String content;
    private LocalDateTime timestamp;

}
