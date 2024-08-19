package faang.school.godbless.sprint2.analysisOfUserActivity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class User implements Comparable<User> {
    private long id;
    private final String name;

    @Override
    public int compareTo(User o) {
        return Long.compare(this.getId(), o.getId());
    }
}
