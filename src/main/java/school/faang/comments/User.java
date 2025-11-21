package school.faang.comments;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class User {
    private final long id;
    private final String name;
}
