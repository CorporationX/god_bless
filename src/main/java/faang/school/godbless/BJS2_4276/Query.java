package faang.school.godbless.BJS2_4276;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static faang.school.godbless.BJS2_4276.ValidateUtils.generateId;
import static faang.school.godbless.BJS2_4276.ValidateUtils.validateStringData;

@Getter
public class Query {

    private static final Set<Long> ID = new HashSet<>();

    private Long id;
    private String content;
    private LocalDateTime timestamp;

    public Query(String content) {
        validateStringData(content);
        this.id = generateId(ID);
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Id: " + getId() + " " +
                "Content: " + getContent();
    }

}
