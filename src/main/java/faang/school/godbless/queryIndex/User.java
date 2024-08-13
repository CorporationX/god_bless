package faang.school.godbless.queryIndex;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
public class User {
    private final long ID;
    private final String NAME;

    @Override
    public String toString() {
        return NAME;
    }
}
