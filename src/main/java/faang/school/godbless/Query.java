package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Query {

    private int id;
    private String content;
    private LocalTime timeStamp;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Query query = (Query) o;
        return id == query.id && content.equals(query.content) && timeStamp.equals(query.timeStamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, timeStamp);
    }
}
