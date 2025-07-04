package school.faang.bjs2_83012;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class User {
    @NonNull
    private final long id;
    @NonNull
    private String name;
}
