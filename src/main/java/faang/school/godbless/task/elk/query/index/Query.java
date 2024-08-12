package faang.school.godbless.task.elk.query.index;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@RequiredArgsConstructor
public class Query {
    private final Long id;
    private final String content;
    private final LocalDateTime timeStamp;
}
