package faang.school.godbless.usersActivity;

import lombok.Data;
import lombok.NonNull;

@Data
public class User {
    @NonNull
    private final int id;
    @NonNull
    private String name;
}
